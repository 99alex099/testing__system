package by.devincubator.dits.services.general.interfaces;

import by.devincubator.dits.entities.Question;

import java.util.List;

public interface QuestionService {

    Question findById(Integer id);

    Question save(Question question);

    void delete(Question question);

    Question findByDescription(String description);

    List<String> findAllQuestionDescriptions();
}
