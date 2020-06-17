package by.devincubator.repository;
import by.devincubator.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
    Optional<Topic> findByTopicId(int topicId);
    Optional<Topic> findByName(String name);
    Optional<Topic> findByDescription(String description);

    @Query("select name from Topic")
    List<String> findAllTopicsNames();
}
