package pl.coderslab.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    @GetMapping("/register")
    public String register (Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    @PostMapping("/register")
    public String register (UserEntity userEntity) {
        userService.add(userEntity);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login (Model model) {
        model.addAttribute("user", new UserEntity());
        return "login";
    }

    @PostMapping("/login")
    @PreAuthorize("hasRole('USER')")
    public String login (UserEntity userEntity) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userEntity.getUsername(), userEntity.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
            return "redirect:/admin";
        }
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit (@AuthenticationPrincipal UserDetails user, Model model) {
        model.addAttribute("user", userService.getUserByUsername(user.getUsername()));
        return "edit-user";
    }

    @PostMapping("/edit")
    public String edit (UserEntity userEntity) {
        userService.edit(userEntity);
        return "redirect:/";
    }
}
