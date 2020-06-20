package by.devincubator.dits.repository;

import by.devincubator.dits.entities.Literature;
import by.devincubator.dits.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LiteratureRepository extends JpaRepository<Literature, Integer> {
    List<Literature> findByQuestion(Question question);
    Optional<Literature> findByLiteratureId(int literatureId);
}
