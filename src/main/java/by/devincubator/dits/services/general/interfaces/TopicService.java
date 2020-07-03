package by.devincubator.dits.services.general.interfaces;

import by.devincubator.dits.entities.Topic;

import java.util.List;

public interface TopicService {
    Topic findByTopicId(Integer id);

    Topic findByName(String name);

    Topic saveTopic(Topic topic);

    void deleteId(Topic topic);

    List<Topic> findTopics();

    List<String> findAllTopicsNames();

    Topic findByDescription(String description);
}
