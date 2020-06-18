package by.devincubator.controllers.user;

import by.devincubator.services.general.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class StartController {

    @Autowired
    private UserService userService;

    private static int counter = 0;

    @GetMapping
    public String mainPage() {
        return "user/mainPage";
    }

    @GetMapping("/not_access")
    public String access() {
        return "user/pageNotAccess";
    }


    @GetMapping(value = "/richest_user")
    public String tmpPage(ModelMap model) {
        model.addAttribute("temp", userService.findByLogin("alex099").getFirstName());
        System.out.println("");
        return "user/richest_user";
    }

    @GetMapping(value = "/admin")
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "user/admin";
    }

    @GetMapping(value = "/user")
    public String userPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "user/profilePage";
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "user/loginPage";
    }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);}
        return "redirect:/login?logout";
    }

    private static String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}