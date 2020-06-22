package by.devincubator.dits.controllers.plug;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminPanel")
public class AdminController {
    @GetMapping
    public String adminPanelPage() {
        return "plugPages/adminPanel";
    }
    @GetMapping("/createUser")
    public String createUserPage() {
        return "plugPages/createUserPage";
    }
    @GetMapping("/createTopic")
    public String createTopicPage() {
        return "plugPages/createTopicPage";
    }
    @GetMapping("/createTest")
    public String createTestPage() {
        return "plugPages/createTestPage";
    }
}
