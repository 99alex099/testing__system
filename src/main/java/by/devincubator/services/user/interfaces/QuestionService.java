package by.devincubator.services.user.interfaces;

import by.devincubator.entities.Question;

public interface QuestionService {

    Question findById(Integer id);
    Question save(Question question);
    void delete(Question question);
}
