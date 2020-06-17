package by.devincubator.services.user.implementations;

import by.devincubator.entities.*;
import by.devincubator.repository.AnswerRepository;
import by.devincubator.repository.LiteratureRepository;
import by.devincubator.repository.StatisticRepository;
import by.devincubator.repository.TestRepository;
import by.devincubator.services.user.dto.QuestionDTO;
import by.devincubator.services.user.dto.ResultDTO;
import by.devincubator.services.user.dto.TestPassingDTO;
import by.devincubator.services.user.exceptions.AnswerIdIsIncorrectException;
import by.devincubator.services.user.exceptions.TestIdIsIncorrectException;
import by.devincubator.services.user.exceptions.TestNotFoundedException;
import by.devincubator.services.user.exceptions.TestNotHavingQuestions;
import by.devincubator.services.user.interfaces.AnswerService;
import by.devincubator.services.user.interfaces.TestService;
import by.devincubator.services.user.interfaces.UserService;
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
    public Question nextQuestion(TestPassingDTO testPassingDTO) {

        if (testHasQuestionWithoutAnswer(testPassingDTO)) {

            int questionNumber = testPassingDTO.getSelectedQuestion();

            do {
                questionNumber++;

                if (questionNumber == testPassingDTO.getQuestionsDTO().size()) {
                    questionNumber = FIRST_QUESTION_INDEX;
                }

                testPassingDTO.setSelectedQuestion(questionNumber);

            } while (questionHasAnswers(testPassingDTO.getQuestionsDTO()
                    .get(questionNumber)));
            return testPassingDTO.getQuestionsDTO().get(questionNumber).getQuestion();
        } else {
            throw new TestNotHavingQuestions(testPassingDTO);
        }
    }

    @Override
    public Question previousQuestion(TestPassingDTO testPassingDTO) {

        if (testHasQuestionWithoutAnswer(testPassingDTO)) {

            int questionNumber = testPassingDTO.getSelectedQuestion();

            do {

                questionNumber = questionNumber == FIRST_QUESTION_INDEX
                        ? testPassingDTO.getQuestionsDTO().size() - 1
                        : testPassingDTO.getSelectedQuestion() - 1;

                testPassingDTO.setSelectedQuestion(questionNumber);
            } while (questionHasAnswers(testPassingDTO.getQuestionsDTO()
                    .get(questionNumber)));
            return testPassingDTO.getQuestionsDTO().get(questionNumber).getQuestion();
        } else {
            throw new TestNotHavingQuestions(testPassingDTO);
        }
    }

    @Override
    public List<String> answersToString(Question question) {
        return question.getAnswers().stream()
                .map(Answer::getDescription)
                .collect(Collectors.toList());
    }

    @Override
    public List<Answer> findAnswersById(List<Integer> answersId) {
        return answersId.stream()
                .map(id -> answerRepository.findById(id)
                        .orElseThrow(() -> new AnswerIdIsIncorrectException(id)))
                .collect(Collectors.toList());
    }

    @Override
    public boolean testHasQuestionWithoutAnswer(TestPassingDTO testPassingDTO) {

        List<QuestionDTO> questionDTOList = testPassingDTO.getQuestionsDTO();

        return questionDTOList.stream()
                .anyMatch(question -> !questionHasAnswers(question));
    }

    @Override
    public boolean questionHasAnswers(QuestionDTO questionDTO) {
        return questionDTO.getUserAnswers() != null;
    }

    @Override
    public List<ResultDTO> fillResultDTO(TestPassingDTO testPassingDTO) {

        List<ResultDTO> resultDTOList = new LinkedList<>();

        List<QuestionDTO> questionDTOList = testPassingDTO.getQuestionsDTO();

        for (QuestionDTO questionDTO : questionDTOList) {
            Question question = questionDTO.getQuestion();

            List<Answer> correctAnswers = answerService.findCorrectAnswers(question);
            resultDTOList.add(
                    new ResultDTO(question.getDescription(),
                            answerService.answersIsEquals(
                                    questionDTO.getUserAnswers(), correctAnswers
                            ),
                            literatureRepository.findByQuestion(question).toString())
            );
        }

        return resultDTOList;
    }


    @Override
    public Statistic saveResults(TestPassingDTO testPassingDTO, String username) {
        List<QuestionDTO> questionDTOList = testPassingDTO.getQuestionsDTO();

        for (QuestionDTO questionDTO : questionDTOList) {
            Question question = questionDTO.getQuestion();

            List<Answer> correctAnswers = answerService.findCorrectAnswers(question);

            Statistic statistic = Statistic.builder()
                    .user(userService.findByLogin(username))
                    .question(question)
                    .isCorrect(answerService.answersIsEquals(
                            questionDTO.getUserAnswers(), correctAnswers
                    ))
                    .build();

            statisticRepository.save(statistic);
        }

        return null;
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
