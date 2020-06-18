package by.devincubator.services.general.implementations;

import by.devincubator.repository.AnswerRepository;
import by.devincubator.entities.Answer;
import by.devincubator.entities.Question;
import by.devincubator.services.general.exceptions.AnswerIdIsIncorrectException;
import by.devincubator.services.general.interfaces.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer findById(Integer id) {
        return answerRepository.findById(id).orElseThrow(() -> new AnswerIdIsIncorrectException(id));
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public void delete(Answer answer) {
        answerRepository.delete(answer);
    }

    @Override
    public List<Answer> findCorrectAnswers(Question question) {
        return question.getAnswers()
                .stream()
                .filter(Answer::isCorrect)
                .collect(Collectors.toList());
    }

    @Override
    public boolean answersIsEquals(List<Answer> userAnswers, List<Answer> correctAnswers) {
        return userAnswers.equals(correctAnswers);
    }
}
