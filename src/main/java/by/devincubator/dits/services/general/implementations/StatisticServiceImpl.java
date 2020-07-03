package by.devincubator.dits.services.general.implementations;

import by.devincubator.dits.services.general.exception.StatisticIdIsIncorrectException;
import by.devincubator.dits.services.general.interfaces.StatisticService;
import by.devincubator.dits.repository.StatisticRepository;
import by.devincubator.dits.entities.Question;
import by.devincubator.dits.entities.Statistic;
import by.devincubator.dits.entities.User;
import by.devincubator.dits.services.general.dto.UserStatisticDTO;
import by.devincubator.dits.services.general.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class StatisticServiceImpl implements StatisticService {

    private StatisticRepository statisticRepository;
    private UserService userService;

    @Autowired
    public void setStatisticRepository(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Statistic findById(Integer id) {
        return statisticRepository.findById(id)
                .orElseThrow(
                        () -> new StatisticIdIsIncorrectException(id));
    }

    @Override
    public Statistic save(Statistic statistic) {
        return statisticRepository.save(statistic);
    }

    @Override
    public void delete(Statistic statistic) {
        statisticRepository.delete(statistic);
    }

    @Override
    public List<Statistic> findByUsername(String username) {
        User user = userService.findByLogin(username);

        return statisticRepository.findByUser(user);
    }

    @Override
    public List<UserStatisticDTO> convertToUserStatisticDTO(List<Statistic> statistics) {

        List<UserStatisticDTO> userStatisticDTOS = new LinkedList<>();

        for (Statistic statistic : statistics) {


            if (!listHasQuestion(userStatisticDTOS, statistic.getQuestion())) {
                UserStatisticDTO userStatisticDTO = new UserStatisticDTO(
                        statistic.getQuestion().getDescription(),
                        statisticRepository.calculateCorrectAnswersPercent(
                                statistic.getUser().getUserId(),
                                statistic.getQuestion().getQuestionId()
                        ),
                        statistic.getQuestion().getTest().getTopic().getName()
                );

                userStatisticDTOS.add(userStatisticDTO);
            }
        }

        return userStatisticDTOS;
    }

    @Override
    public boolean listHasQuestion(List<UserStatisticDTO> userStatisticDTOS, Question question) {
        return userStatisticDTOS.stream()
                .anyMatch(userStatisticDTO -> userStatisticDTO.getQuestion().equals(question.getDescription()));
    }
}
