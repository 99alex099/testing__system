package by.devincubator.dits.repository;

import by.devincubator.dits.entities.Test;
import by.devincubator.dits.entities.Topic;
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
