package by.devincubator.dits.services.general.implementations;

import by.devincubator.dits.entities.Answer;
import by.devincubator.dits.entities.Question;
import by.devincubator.dits.repository.AnswerRepository;
import by.devincubator.dits.services.general.exception.AnswerIdIsIncorrectException;
import by.devincubator.dits.services.general.interfaces.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public void setAnswerRepository(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

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
    public boolean answersAreEquals(List<Answer> userAnswers, List<Answer> correctAnswers) {
        return userAnswers.equals(correctAnswers);
    }


    @Override
    public List<Answer> findAnswersById(List<Integer> answersId) {
        return answersId.stream()
                .map(id -> answerRepository.findById(id)
                        .orElseThrow(() -> new AnswerIdIsIncorrectException(id)))
                .collect(Collectors.toList());
    }
}
