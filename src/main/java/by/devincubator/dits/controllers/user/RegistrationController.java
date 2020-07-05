package by.devincubator.dits.controllers.user;

import by.devincubator.dits.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import by.devincubator.dits.services.general.interfaces.UserService;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public ModelAndView showRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("user/registrationPage");
        return modelAndView;
    }
    @PostMapping("/registration")
    public ModelAndView registration(@ModelAttribute(name = "user") User user) {

        userService.registrationUser(user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/successfullyRegistrationPage");
        return modelAndView;
    }
}
