package by.devincubator.dits.controllers.admin;

import by.devincubator.dits.services.admin.adminservices.TestCreationService;
import by.devincubator.dits.services.general.interfaces.QuestionService;
import by.devincubator.dits.services.general.interfaces.TestService;
import by.devincubator.dits.services.general.interfaces.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestCreationController {

    private TopicService topicService;
    private TestService testService;
    private QuestionService questionService;
    private TestCreationService testCreationService;

    @Autowired
    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Autowired
    public void setTestCreationService(TestCreationService testCreationService) {
        this.testCreationService = testCreationService;
    }

    @GetMapping(value = "/creationOptions")
    public ModelAndView getCreationOptionsPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPages/creationOptions");
        return modelAndView;
    }

    @GetMapping(value = "/createTest")
    public ModelAndView createTestPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("topicsNames", topicService.findAllTopicsNames());
        modelAndView.addObject("testsNames", testService.findAllTestNames());
        modelAndView.addObject("questionsNames", questionService.findAllQuestionDescriptions());
        modelAndView.setViewName("adminPages/createTest");
        return modelAndView;
    }

    @PostMapping(value = "/createTest")
    public ModelAndView createTest(@RequestParam(name = "chosenTopic") String topicName,
                                   @RequestParam(name = "chosenTest", required = false) String testName,
                                   @RequestParam(name = "chosenQuestion", required = false) String questionDescription) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/creationOptions");

        testCreationService.createTestByAdmin(topicName, testName, questionDescription);

        return modelAndView;
    }
}