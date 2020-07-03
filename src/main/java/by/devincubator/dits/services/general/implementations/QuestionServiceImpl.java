package by.devincubator.dits.services.general.implementations;

import by.devincubator.dits.entities.Question;
import by.devincubator.dits.repository.QuestionRepository;
import by.devincubator.dits.services.general.exceptions.QuestionIdIsIncorrectException;
import by.devincubator.dits.services.general.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

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

    @Override
    public Question findByDescription(String description) {
        return questionRepository.findQuestionByDescription(description)
                .orElse(null);
    }

    @Override
    public List<String> findAllQuestionDescriptions() {
        return questionRepository.findAllQuestionDescriptions();
    }
}
