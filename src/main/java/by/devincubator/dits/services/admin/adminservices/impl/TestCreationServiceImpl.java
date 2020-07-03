package by.devincubator.dits.services.admin.adminservices.impl;

import by.devincubator.dits.entities.Question;
import by.devincubator.dits.entities.Test;
import by.devincubator.dits.entities.Topic;
import by.devincubator.dits.services.admin.adminservices.TestCreationService;
import by.devincubator.dits.services.general.exception.TestNotFoundedException;
import by.devincubator.dits.services.general.exception.TopicNotFoundedByNameException;
import by.devincubator.dits.services.general.exception.UnknownCreationException;
import by.devincubator.dits.services.general.interfaces.QuestionService;
import by.devincubator.dits.services.general.interfaces.TestService;
import by.devincubator.dits.services.general.interfaces.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Service
public class TestCreationServiceImpl implements TestCreationService {

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

    @Override
    public void createTestByAdmin(String topicName, String testName, String questionDescription) {

        if (!topicName.isEmpty() && !testName.isEmpty() && !questionDescription.isEmpty()) {
            Question question = getQuestion(questionDescription);

            Test test = getTest(testName);
            test.addQuestionToList(question);

            question.setTest(test);

            Topic topic = getTopic(topicName);
            topic.addTestToList(test);

            test.setTopic(topic);

            topicService.saveTopic(topic);
            testService.save(test);
            questionService.save(question);
        } else if (questionDescription.isEmpty() && !testName.isEmpty() && !topicName.isEmpty()) {
            Test test = getTest(testName);

            Topic topic = getTopic(topicName);
            topic.addTestToList(test);

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

        Test test = null;

        try {
            test = testService.findTestByName(testName);
        } catch (TestNotFoundedException e) {
        }

        if (test == null) {
            test = Test.builder()
                    .name(testName)
                    .build();
        }
        return test;
    }

    private Topic getTopic(String topicName) {

        Topic topic = null;

        try {
            topic = topicService.findByName(topicName);
        } catch (TopicNotFoundedByNameException e) {
        }

        if (topic == null) {
            topic = Topic.builder()
                    .name(topicName)
                    .tests(new ArrayList<Test>())
                    .build();
        }
        return topic;
    }
}