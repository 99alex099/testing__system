package by.devincubator.dits.services.general.implementations;

import by.devincubator.dits.entities.Answer;
import by.devincubator.dits.entities.Question;
import by.devincubator.dits.entities.Test;
import by.devincubator.dits.entities.Topic;
import by.devincubator.dits.repository.AnswerRepository;
import by.devincubator.dits.repository.LiteratureRepository;
import by.devincubator.dits.repository.StatisticRepository;
import by.devincubator.dits.repository.TestRepository;
import by.devincubator.dits.services.general.exceptions.TestIdIsIncorrectException;
import by.devincubator.dits.services.general.interfaces.AnswerService;
import by.devincubator.dits.services.general.interfaces.TestService;
import by.devincubator.dits.entities.*;
import by.devincubator.dits.services.general.exceptions.TestNotFoundedException;
import by.devincubator.dits.services.general.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {

    private static final int FIRST_QUESTION_INDEX = 0;

    private final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public Test findById(Integer id) {
        return testRepository.findByTestId(id)
                .orElseThrow(
                        () -> new TestIdIsIncorrectException(id)
                );
    }

    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }

    @Override
    public void delete(Test test) {
        testRepository.delete(test);
    }

    @Override
    public List<Question> formQuestionsByTest(Test test) {
        Collections.shuffle(test.getQuestions());
        return test.getQuestions();
    }

    @Override
    public Test findByTopicAndTestName(Topic topic, String name) {
        return testRepository.findByTopicAndName(topic, name).orElseThrow(
                () -> new TestNotFoundedException(name, topic)
        );
    }


    @Override
    public List<String> answersToString(Question question) {
        return question.getAnswers().stream()
                .map(Answer::getDescription)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllTestNames() {
        return testRepository.findAllTestNames();
    }

    @Override
    public Test findTestByName(String description) {
        return testRepository.findTestByName(description)
                .orElse(null);
    }
}
