package by.devincubator.services.general.interfaces;

import by.devincubator.entities.Question;

import java.util.List;

public interface QuestionService {

    Question findById(Integer id);
    Question save(Question question);
    void delete(Question question);

    Question findByDescription(String description);
    List<String> findAllQuestionDescriptions();
}
