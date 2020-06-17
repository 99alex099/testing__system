package by.devincubator.repository;

import by.devincubator.entities.Literature;
import by.devincubator.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiteratureRepository extends JpaRepository<Literature, Integer> {
    List<Literature> findByQuestion(Question question);
}
