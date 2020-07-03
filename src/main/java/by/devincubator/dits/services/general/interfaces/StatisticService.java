package by.devincubator.dits.services.general.interfaces;

import by.devincubator.dits.entities.Question;
import by.devincubator.dits.entities.Statistic;
import by.devincubator.dits.services.general.dto.UserStatisticDTO;

import java.util.List;

public interface StatisticService {
    Statistic findById(Integer id);

    Statistic save(Statistic statistic);

    void delete(Statistic statistic);

    List<Statistic> findByUsername(String username);

    List<UserStatisticDTO> convertToUserStatisticDTO(List<Statistic> statistics);

    boolean listHasQuestion(List<UserStatisticDTO> userStatisticDTOS, Question question);
}
