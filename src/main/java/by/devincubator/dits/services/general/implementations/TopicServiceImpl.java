package by.devincubator.dits.services.general.implementations;

import by.devincubator.dits.services.general.interfaces.TopicService;
import by.devincubator.dits.repository.TopicRepository;
import by.devincubator.dits.entities.Topic;
import by.devincubator.dits.services.general.exceptions.TopicIdIsIncorrectException;
import by.devincubator.dits.services.general.exceptions.TopicNotFoundedByNameException;
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
