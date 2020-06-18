package by.devincubator.dits.controllers.user;

import by.devincubator.dits.services.general.dto.UserAnswersDTO;
import by.devincubator.dits.services.general.interfaces.TopicService;
import by.devincubator.dits.entities.Test;
import by.devincubator.dits.entities.Topic;
import by.devincubator.dits.services.general.dto.TestPassingDTO;
import by.devincubator.dits.services.general.interfaces.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes(types = {Topic.class, TestPassingDTO.class, UserAnswersDTO.class},
        value = {"selectedAnswers"})
public class TestStarterController {

    private static final String MESSAGE_TEXT_NOT_SELECTED =
            "You have to choose topic before you'll select test";

    @Autowired
    private TopicService topicService;
    @Autowired
    private TestService testService;

    @GetMapping("/choose_topic")
    public String chooseTopic(Model model) {
        model.addAttribute("topics", topicService.findTopics());
        return "user/choose_topic";
    }

    @GetMapping("/select_topic")
    public String selectTopic(Model model, @RequestParam("topicOption") int topicId) {
        model.addAttribute(topicService.findByTopicId(topicId));
        return "redirect:/choose_test";
    }

    @GetMapping(value = "/choose_test")
    public String chooseTest(Model model, Topic topic) {
        System.out.println(topic.getTests());
        if (topic.getName() != null) {
            model.addAttribute("tests", topic.getTests());
            return "user/chooseTestPage";
        } else {
            model.addAttribute("errorText",
                    MESSAGE_TEXT_NOT_SELECTED);
            return "user/errorPage";
        }
    }

    @GetMapping(value = "/select_test")
    public String selectTest(Model model, Topic topic,
                             @RequestParam("testOption") int testId,
                             SessionStatus sessionStatus) {

        Test selectedTest = testService.findById(testId);

        TestPassingDTO testPassing = new TestPassingDTO(
                selectedTest,
                testService.formQuestionsByTest(selectedTest));

        //sessionStatus.setComplete(); //вставить в сервисы | разобраться со сессиями
//        sessionStatus.setComplete();
        model.addAttribute("testPassing", testPassing);
        return "redirect:/start_test";
    }

    @GetMapping("/start_test")
    public String startTest(@ModelAttribute(name = "testPassing") TestPassingDTO testPassing) {

        return "user/startTestPage";

    }
}