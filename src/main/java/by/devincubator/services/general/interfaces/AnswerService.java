package by.devincubator.services.general.interfaces;

import by.devincubator.entities.Answer;
import by.devincubator.entities.Question;

import java.util.List;

public interface AnswerService {
    Answer findById(Integer id);
    Answer save(Answer answer);
    void delete(Answer answer);
    List<Answer> findCorrectAnswers(Question question);
    boolean answersIsEquals(List<Answer> userAnswers, List<Answer> correctAnswers);
    List<Answer> findAnswersById(List<Integer> answersId);
}
