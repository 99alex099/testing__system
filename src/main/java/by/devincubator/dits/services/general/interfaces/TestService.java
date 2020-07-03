package by.devincubator.dits.services.general.interfaces;

import by.devincubator.dits.entities.Question;
import by.devincubator.dits.entities.Test;
import by.devincubator.dits.entities.Topic;
import by.devincubator.dits.entities.*;

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
