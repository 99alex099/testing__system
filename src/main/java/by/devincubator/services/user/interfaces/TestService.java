package by.devincubator.services.user.interfaces;

import by.devincubator.entities.*;
import by.devincubator.services.user.dto.QuestionDTO;
import by.devincubator.services.user.dto.ResultDTO;
import by.devincubator.services.user.dto.TestPassingDTO;

import java.util.List;

public interface TestService {
    Test findById(Integer id);
    Test save(Test test);
    void delete(Test test);
    List<Question> formQuestionsByTest(Test test);
    Test findByTopicAndTestName(Topic topic, String name);
    Question nextQuestion(TestPassingDTO testPassingDTO);
    Question previousQuestion(TestPassingDTO testPassingDTO);
    List<String> answersToString(Question question);
    List<Answer> findAnswersById(List<Integer> answersId);
    boolean testHasQuestionWithoutAnswer(TestPassingDTO testPassingDTO);
    boolean questionHasAnswers(QuestionDTO questionDTO);
    List<ResultDTO> fillResultDTO(TestPassingDTO testPassingDTO);
    Statistic saveResults(TestPassingDTO testPassingDTO, String username);

    List<String> findAllTestNames();
    Test findTestByName(String description);
}
