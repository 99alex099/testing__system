package by.devincubator.services.general.interfaces;

import by.devincubator.entities.*;
import by.devincubator.services.general.dto.QuestionDTO;
import by.devincubator.services.general.dto.ResultDTO;
import by.devincubator.services.general.dto.TestPassingDTO;

import java.util.List;

public interface TestService {
    Test findById(Integer id);
    Test save(Test test);
    void delete(Test test);
    List<Question> formQuestionsByTest(Test test);
    Test findByTopicAndTestName(Topic topic, String name);
    List<String> answersToString(Question question);

    List<String> findAllTestNames();
    Test findTestByName(String description);
}
