package by.devincubator.services.user.implementations;

import by.devincubator.repository.TopicRepository;
import by.devincubator.entities.Topic;
import by.devincubator.services.user.exceptions.TopicIdIsIncorrectException;
import by.devincubator.services.user.exceptions.TopicNotFoundedByNameException;
import by.devincubator.services.user.interfaces.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public Topic findByTopicId(Integer id) {
        return topicRepository.findByTopicId(id).orElseThrow(() -> new TopicIdIsIncorrectException(id));
    }

    @Override
    public Topic findByName(String name) {
        return topicRepository.findByName(name).orElseThrow(() -> new TopicNotFoundedByNameException(name));
    }

    @Override
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public void deleteId(Topic topic) {
        topicRepository.delete(topic);
    }

    @Override
    public List<Topic> findTopics() {
        return topicRepository.findAll();
    }

    @Override
    public List<String> findAllTopicsNames() {
        return topicRepository.findAllTopicsNames();
    }

    @Override
    public Topic findByDescription(String description) {
        return topicRepository.findByDescription(description)
                .orElse(null);

    }
}
