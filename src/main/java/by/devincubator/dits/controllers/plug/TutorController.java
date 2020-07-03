package by.devincubator.dits.controllers.plug;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tutorPanel")
public class TutorController {

    @PostMapping
    public String tutorPost() {
        return "plugPages/tutorPage";
    }
    @PostMapping("/questions")
    public String questionsPost() {
        return "plugPages/editQuestions";
    }
    @GetMapping
    public String tutorPage() {
        return "plugPages/tutorPage";
    }
    @GetMapping("/questions")
    public String questionsPage() {
        return "plugPages/editQuestions";
    }
}
