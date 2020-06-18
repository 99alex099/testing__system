package by.devincubator.services.user.interfaces;

import by.devincubator.services.general.dto.QuestionDTO;
import by.devincubator.services.general.dto.ResultDTO;
import by.devincubator.services.general.dto.TestPassingDTO;

import java.util.List;

public interface TestingService {
    void nextQuestion(TestPassingDTO testPassingDTO);
    void previousQuestion(TestPassingDTO testPassingDTO);
    boolean testHasQuestionWithoutAnswer(TestPassingDTO testPassingDTO);
    boolean questionHasAnswers(QuestionDTO questionDTO);
    List<ResultDTO> fillResultDTO(TestPassingDTO testPassingDTO);
    void saveResults(TestPassingDTO testPassingDTO, String username);
}
