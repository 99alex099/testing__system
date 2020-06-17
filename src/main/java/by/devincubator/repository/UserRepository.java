package by.devincubator.repository;

import by.devincubator.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLogin(String login);
    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);
    boolean existsByLogin(String login);
}
