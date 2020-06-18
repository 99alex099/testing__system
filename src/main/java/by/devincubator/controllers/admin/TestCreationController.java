package by.devincubator.controllers.admin;

import by.devincubator.entities.Question;
import by.devincubator.entities.Test;
import by.devincubator.entities.Topic;
import by.devincubator.services.general.exceptions.UnknownCreationException;
import by.devincubator.services.general.interfaces.QuestionService;
import by.devincubator.services.general.interfaces.TestService;
import by.devincubator.services.general.interfaces.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class TestCreationController {

    private TopicService topicService;
    private TestService testService;
    private QuestionService questionService;

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


        if (!topicName.isEmpty() && !testName.isEmpty() && !questionDescription.isEmpty()) {
            Question question = getQuestion(questionDescription);

            Test test = getTest(testName);
            // test.addQuestionToList(question)
            // changed to
            test.getQuestions().add(question);
            //

            question.setTest(test);

            Topic topic = getTopic(topicName);

            //topic.addTestToList(test);
            topic.getTests().add(test);
            //
            test.setTopic(topic);

            topicService.saveTopic(topic);
            testService.save(test);
            questionService.save(question);
        } else if (questionDescription.isEmpty() && !testName.isEmpty() && !topicName.isEmpty()) {
            Test test = getTest(testName);

            Topic topic = getTopic(topicName);
            //topic.addTestToList(test);
            topic.getTests().add(test);

            test.setTopic(topic);

            topicService.saveTopic(topic);
            testService.save(test);
        } else if (questionDescription.isEmpty() && testName.isEmpty() && !topicName.isEmpty()) {
            Topic topic = getTopic(topicName);
            topicService.saveTopic(topic);
        } else if (!questionDescription.isEmpty() && testName.isEmpty() && !topicName.isEmpty() ||
                !questionDescription.isEmpty() && testName.isEmpty() && topicName.isEmpty()) {
            throw new UnknownCreationException("Please choose or create a test!");
        } else {
            throw new UnknownCreationException("Something wrong has happened!");
        }
        return modelAndView;
    }

    private Question getQuestion(String questionDescription) {

        Question question = questionService.findByDescription(questionDescription);
        if (question == null) {
            question = Question.builder()
                    .description(questionDescription)
                    .build();
        }
        return question;
    }

    private Test getTest(String testName) {

        Test test = testService.findTestByName(testName);
        if (test == null) {
            test = Test.builder()
                    .name(testName)
                    .build();

        }
        return test;
    }

    private Topic getTopic(String topicName) {

        Topic topic = topicService.findByName(topicName);
        if (topic == null) {
            topic = Topic.builder()
                    .name(topicName)
                    .tests(new ArrayList<Test>())
                    .build();
        }
        return topic;
    }
}