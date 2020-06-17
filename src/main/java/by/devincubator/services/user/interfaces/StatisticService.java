package by.devincubator.services.user.interfaces;

import by.devincubator.entities.Question;
import by.devincubator.entities.Statistic;
import by.devincubator.services.user.dto.UserStatisticDTO;

import java.util.List;

public interface StatisticService {
    Statistic findById(Integer id);
    Statistic save(Statistic statistic);
    void delete(Statistic statistic);
    List<Statistic> findByUsername(String username);
    List<UserStatisticDTO> convertToUserStatisticDTO(List<Statistic> statistics);
    boolean listHasQuestion(List<UserStatisticDTO> userStatisticDTOS, Question question);
}
