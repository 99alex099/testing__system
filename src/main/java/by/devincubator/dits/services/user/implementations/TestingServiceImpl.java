package by.devincubator.dits.services.user.implementations;

import by.devincubator.dits.entities.Answer;
import by.devincubator.dits.entities.Literature;
import by.devincubator.dits.entities.Question;
import by.devincubator.dits.entities.Statistic;
import by.devincubator.dits.repository.LiteratureRepository;
import by.devincubator.dits.repository.StatisticRepository;
import by.devincubator.dits.services.general.dto.LiteratureDTO;
import by.devincubator.dits.services.general.dto.QuestionDTO;
import by.devincubator.dits.services.general.dto.ResultDTO;
import by.devincubator.dits.services.general.exception.TestNotHavingQuestions;
import by.devincubator.dits.services.general.interfaces.AnswerService;
import by.devincubator.dits.services.general.dto.TestPassingDTO;
import by.devincubator.dits.services.general.interfaces.LiteratureService;
import by.devincubator.dits.services.general.interfaces.UserService;
import by.devincubator.dits.services.user.interfaces.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestingServiceImpl implements TestingService {

    private static final int FIRST_QUESTION_INDEX = 0;

    private final AnswerService answerService;
    private final LiteratureRepository literatureRepository;
    private final UserService userService;
    private final StatisticRepository statisticRepository;
    private final LiteratureService literatureService;

    public TestingServiceImpl(AnswerService answerService, LiteratureRepository literatureRepository, UserService userService, StatisticRepository statisticRepository, LiteratureService literatureService) {
        this.answerService = answerService;
        this.literatureRepository = literatureRepository;
        this.userService = userService;
        this.statisticRepository = statisticRepository;
        this.literatureService = literatureService;
    }

    @Override
    public boolean testHasQuestionWithoutAnswer(TestPassingDTO testPassingDTO) {

        return testPassingDTO.getQuestionsDTO().stream()
                .anyMatch(question -> !questionHasAnswers(question));
    }

    @Override
    public boolean questionHasAnswers(QuestionDTO questionDTO) {
        return questionDTO.getUserAnswers() != null;
    }
    private long calculateCorrectAnswers(TestPassingDTO testPassingDTO) {
        return testPassingDTO.getQuestionsDTO().stream()
                .filter(questionDTO -> answerService.answersAreEquals(
                        questionDTO.getUserAnswers(),
                        answerService.findCorrectAnswers(questionDTO.getQuestion())
                ))
                .count();
    }

    @Override
    public ResultDTO fillResultDTO(TestPassingDTO testPassingDTO) {

        return new ResultDTO(calculateCorrectAnswers(testPassingDTO),
                testPassingDTO.getQuestionsDTO().size(), formLiteratureDTOByTestPassing(testPassingDTO));
    }

    @Override
    public void saveResults(TestPassingDTO testPassingDTO, String username) {
        List<QuestionDTO> questionDTOList = testPassingDTO.getQuestionsDTO();

        for (QuestionDTO questionDTO : questionDTOList) {
            Question question = questionDTO.getQuestion();

            List<Answer> correctAnswers = answerService.findCorrectAnswers(question);

            Statistic statistic = Statistic.builder()
                    .user(userService.findByLogin(username))
                    .question(question)
                    .isCorrect(answerService.answersAreEquals(
                            questionDTO.getUserAnswers(), correctAnswers
                    ))
                    .date(new Date())
                    .build();

            statisticRepository.save(statistic);
        }
    }

    @Override
    public List<LiteratureDTO> formLiteratureDTOByQuestion(Question question) {

        return literatureRepository.findByQuestion(question).stream()
                .map(literature -> new LiteratureDTO(
                        literature.getDescription(),
                        literatureService.formLinkToLiteratureInfo(literature)
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<LiteratureDTO> formLiteratureDTOByTestPassing(TestPassingDTO testPassingDTO) {

        List<Question> questionsWithCorrectAnswers = testPassingDTO.getQuestionsDTO().stream()
                .filter(questionDTO -> !answerService.answersAreEquals(
                        questionDTO.getUserAnswers(),
                        answerService.findCorrectAnswers(questionDTO.getQuestion())
                ))
                .map(QuestionDTO::getQuestion)
                .collect(Collectors.toList());

        List<LiteratureDTO> literatureDTOS = new LinkedList<>();

        for (Question question : questionsWithCorrectAnswers) {
            for (Literature literature : literatureRepository.findByQuestion(question)) {
                literatureDTOS.add(new LiteratureDTO(literature.getDescription(),
                        literatureService.formLinkToLiteratureInfo(literature)));
            }
        }

        return literatureDTOS;

    }

    @Override
    public void nextQuestion(TestPassingDTO testPassingDTO) {

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
        } else {
            throw new TestNotHavingQuestions(testPassingDTO);
        }
    }

    @Override
    public void previousQuestion(TestPassingDTO testPassingDTO) {

        if (testHasQuestionWithoutAnswer(testPassingDTO)) {

            int questionNumber = testPassingDTO.getSelectedQuestion();

            do {

                questionNumber = questionNumber == FIRST_QUESTION_INDEX
                        ? testPassingDTO.getQuestionsDTO().size() - 1
                        : testPassingDTO.getSelectedQuestion() - 1;

                testPassingDTO.setSelectedQuestion(questionNumber);
            } while (questionHasAnswers(testPassingDTO.getQuestionsDTO()
                    .get(questionNumber)));
        } else {
            throw new TestNotHavingQuestions(testPassingDTO);
        }
    }
}
