package by.devincubator.dits.controllers.plug;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tutorPanel")
public class TutorController {
    @GetMapping
    public String tutorPage() {
        return "plugPages/tutorPage";
    }
    @GetMapping("/questions")
    public String questionsPage() {
        return "plugPages/editQuestions";
    }
}
