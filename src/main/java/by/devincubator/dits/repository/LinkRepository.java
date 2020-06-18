package by.devincubator.dits.repository;

import by.devincubator.dits.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link, Integer> {
}
