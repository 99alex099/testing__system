package by.devincubator.dits.services.general.interfaces;

import by.devincubator.dits.entities.Answer;
import by.devincubator.dits.entities.Question;

import java.util.List;

public interface AnswerService {
    Answer findById(Integer id);
    Answer save(Answer answer);
    void delete(Answer answer);
    List<Answer> findCorrectAnswers(Question question);
    boolean answersAreEquals(List<Answer> userAnswers, List<Answer> correctAnswers);
    List<Answer> findAnswersById(List<Integer> answersId);
}
