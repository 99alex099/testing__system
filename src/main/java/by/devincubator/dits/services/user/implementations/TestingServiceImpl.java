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
import by.devincubator.dits.services.general.exceptions.TestNotHavingQuestions;
import by.devincubator.dits.services.general.interfaces.AnswerService;
import by.devincubator.dits.services.general.dto.TestPassingDTO;
import by.devincubator.dits.services.general.interfaces.LiteratureService;
import by.devincubator.dits.services.general.interfaces.UserService;
import by.devincubator.dits.services.user.interfaces.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestingServiceImpl implements TestingService {

    private static final int FIRST_QUESTION_INDEX = 0;

    @Autowired
    private AnswerService answerService;
    @Autowired
    private LiteratureRepository literatureRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private StatisticRepository statisticRepository;
    @Autowired
    private LiteratureService literatureService;

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
                            answerService.answersAreEquals(
                                    questionDTO.getUserAnswers(), correctAnswers
                            ),
                            formLiteratureDTOByQuestion(question))
            );
        }

        return resultDTOList;
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
                    .build();

            statisticRepository.save(statistic);
        }
    }

    @Override
    public List<LiteratureDTO> formLiteratureDTOByQuestion(Question question) {

        List<Literature> literatureList = literatureRepository.findByQuestion(question);

        return literatureList.stream()
                .map(literature -> new LiteratureDTO(
                        literature.getDescription(),
                        literatureService.formLinkToLiteratureInfo(literature)
                ))
                .collect(Collectors.toList());
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
