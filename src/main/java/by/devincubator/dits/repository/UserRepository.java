package by.devincubator.dits.repository;

import by.devincubator.dits.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();
    Optional<User> findByLogin(String login);
    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);
    boolean existsByLogin(String login);

    @Query("select u from User u where u.isApproved=0")
    List<User> findAllUnapprovedUsers();

}
