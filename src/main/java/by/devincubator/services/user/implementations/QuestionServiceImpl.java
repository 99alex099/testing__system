package by.devincubator.services.user.implementations;

import by.devincubator.repository.QuestionRepository;
import by.devincubator.entities.Question;
import by.devincubator.services.user.exceptions.QuestionIdIsIncorrectException;
import by.devincubator.services.user.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question findById(Integer id) {
        return questionRepository.findById(id)
                .orElseThrow(
                        () -> new QuestionIdIsIncorrectException(id)
                );
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void delete(Question question) {
        questionRepository.delete(question);
    }
}
