package by.devincubator.repository;

import by.devincubator.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    Optional<Question> findQuestionByDescription(String description);

    @Query(value = "select description from Question")
    List<String> findAllQuestionDescriptions();
}
