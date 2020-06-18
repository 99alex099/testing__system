package by.devincubator.dits.repository;

import by.devincubator.dits.entities.Question;
import by.devincubator.dits.entities.User;
import by.devincubator.dits.entities.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Integer> {
    void deleteByUserAndQuestion(User user, Question question);
    List<Statistic> findByUser(User user);
    @Query(value = "CALL calculate_percent_correct_answers(:userId, :questionId);", nativeQuery = true)
    double calculateCorrectAnswersPercent(@Param("userId") Integer userId,
                                          @Param("questionId") Integer questionId);
}
