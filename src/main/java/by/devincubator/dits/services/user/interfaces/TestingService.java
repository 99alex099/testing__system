package by.devincubator.dits.services.user.interfaces;

import by.devincubator.dits.entities.Literature;
import by.devincubator.dits.entities.Question;
import by.devincubator.dits.services.general.dto.LiteratureDTO;
import by.devincubator.dits.services.general.dto.QuestionDTO;
import by.devincubator.dits.services.general.dto.ResultDTO;
import by.devincubator.dits.services.general.dto.TestPassingDTO;

import java.util.List;

public interface TestingService {
    void nextQuestion(TestPassingDTO testPassingDTO);
    void previousQuestion(TestPassingDTO testPassingDTO);
    boolean testHasQuestionWithoutAnswer(TestPassingDTO testPassingDTO);
    boolean questionHasAnswers(QuestionDTO questionDTO);
    List<ResultDTO> fillResultDTO(TestPassingDTO testPassingDTO);
    void saveResults(TestPassingDTO testPassingDTO, String username);
    List<LiteratureDTO> formLiteratureDTOByQuestion(Question question);
}
