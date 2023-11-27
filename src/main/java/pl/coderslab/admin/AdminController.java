package pl.coderslab.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.donation.DonationService;
import pl.coderslab.institution.InstitutionService;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final InstitutionService institutionService;
    private final DonationService donationService;

    @GetMapping("")
    public String dashboard (Model model) {
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("donationQuantity", donationService.countAllQuantity());
        model.addAttribute("donationCount", donationService.countAllDonations());
        return "indexAdmin";
    }

    @GetMapping("/institutions")
    public String institutions (Model model) {
        model.addAttribute("institutions", institutionService.findAll());
        return "institutions";
    }
}
