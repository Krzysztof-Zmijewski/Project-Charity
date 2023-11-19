package pl.coderslab.donation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.category.CategoryService;
import pl.coderslab.institution.InstitutionService;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class DonationController {
    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    @GetMapping("/form")
    public String donationForm (Model model) {
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("institutions", institutionService.findAll());
        return "form";
    }
}
