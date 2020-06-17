package by.devincubator.repository;

import by.devincubator.entities.Test;
import by.devincubator.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
    Optional<Test> findByTopicAndName(Topic topic, String name);
    Optional<Test> findByTestId(int testId);


    Optional<Test> findTestByName(String name);

    @Query("select name FROM Test")
    List<String> findAllTestNames();
}
