package by.devincubator.services.general.implementations;

import by.devincubator.entities.*;
import by.devincubator.repository.AnswerRepository;
import by.devincubator.repository.LiteratureRepository;
import by.devincubator.repository.StatisticRepository;
import by.devincubator.repository.TestRepository;
import by.devincubator.services.general.dto.QuestionDTO;
import by.devincubator.services.general.dto.ResultDTO;
import by.devincubator.services.general.dto.TestPassingDTO;
import by.devincubator.services.general.exceptions.AnswerIdIsIncorrectException;
import by.devincubator.services.general.exceptions.TestIdIsIncorrectException;
import by.devincubator.services.general.exceptions.TestNotFoundedException;
import by.devincubator.services.general.exceptions.TestNotHavingQuestions;
import by.devincubator.services.general.interfaces.AnswerService;
import by.devincubator.services.general.interfaces.TestService;
import by.devincubator.services.general.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {

    private static final int FIRST_QUESTION_INDEX = 0;

    @Autowired
    private TestRepository testRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private StatisticRepository statisticRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private LiteratureRepository literatureRepository;

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
