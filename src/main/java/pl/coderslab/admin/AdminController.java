package pl.coderslab.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.donation.DonationService;
import pl.coderslab.institution.Institution;
import pl.coderslab.institution.InstitutionService;
import pl.coderslab.user.UserEntity;
import pl.coderslab.user.UserService;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final UserService userService;

    @GetMapping("")
    public String dashboard (Model model) {
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("donationQuantity", donationService.countAllQuantity());
        model.addAttribute("donationCount", donationService.countAllDonations());
        return "indexAdmin";
    }
    // Institutions CRUD
    @GetMapping("/institutions")
    public String institutions (Model model) {
        model.addAttribute("institutions", institutionService.findAll());
        return "institutions";
    }

    @GetMapping("/institutions/edit")
    public String institutionEdit (@RequestParam Long id, Model model) {
        model.addAttribute("institution", institutionService.get(id));
        return "institutions-edit";
    }

    @PostMapping("/institutions/edit")
    public String institutionsEdit (Institution institution) {
        institutionService.update(institution);
        return "redirect:/admin/institutions";
    }

    @GetMapping("/institutions/delete")
    public String institutionsDelete (@RequestParam Long id, Model model) {
        model.addAttribute("institution", institutionService.get(id));
        return "institutions-delete-confirmation";
    }

    @PostMapping("/institutions/delete")
    public String institutionsDelete (Institution institution) {
        institutionService.delete(institution);
        return "redirect:/admin/institutions";
    }

    @GetMapping("/institutions/add")
    public String institutionsAdd (Model model) {
        model.addAttribute("institution", new Institution());
        return "institutions-add";
    }

    @PostMapping("/institutions/add")
    public String institutionsAdd (Institution institution) {
        institutionService.add(institution);
        return "redirect:/admin/institutions";
    }
    //Admin CRUD
    @GetMapping("/admins")
    public String adminList (Model model) {
        model.addAttribute("admins", userService.getAllAdmins());
        return "admins-view";
    }

    @GetMapping("/edit")
    public String adminEdit (@RequestParam Long id, Model model) {
        model.addAttribute("admin", userService.get(id));
        return "admins-edit";
    }

    @PostMapping("/edit")
    public String adminEdit (UserEntity userEntity) {
        userService.edit(userEntity);
        return "redirect:/admin/admins";
    }

    @GetMapping("/add")
    public String adminAdd (Model model) {
        model.addAttribute("admin", new UserEntity());
        return "admins-add";
    }

    @PostMapping("/add")
    public String adminAdd (UserEntity userEntity) {
        userService.addAdmin(userEntity);
        return "redirect:/admin/admins";
    }

    @GetMapping("/delete")
    public String adminDelete (@RequestParam Long id, Model model) {
        model.addAttribute("admin", userService.get(id));
        return "admins-delete-confirmation";
    }

    @PostMapping("/delete")
    public String adminDelete (UserEntity userEntity) {
        userService.remove(userEntity);
        return "redirect:/admin/admins";
    }
    //Users CRUD
    @GetMapping("/users")
    public String userList (Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users-view";
    }

    @GetMapping("/users/edit")
    public String usersEdit (@RequestParam Long id ,Model model) {
        model.addAttribute("user", userService.get(id));
        return "users-edit";
    }

    @PostMapping("/users/edit")
    public String usersEdit (UserEntity userEntity) {
        userService.edit(userEntity);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/add")
    public String usersAdd (Model model) {
        model.addAttribute("user", new UserEntity());
        return "users-add";
    }

    @PostMapping("/users/add")
    public String usersAdd (UserEntity userEntity) {
        userService.add(userEntity);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/delete")
    public String usersDelete (@RequestParam Long id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "users-delete-confirmation";
    }

    @PostMapping("users/delete")
    public String usersDelete (UserEntity userEntity) {
        userService.remove(userEntity);
        return "redirect:/admin/users";
    }
}
