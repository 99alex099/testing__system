package by.devincubator.services.user.implementations;

import by.devincubator.repository.StatisticRepository;
import by.devincubator.entities.Question;
import by.devincubator.entities.Statistic;
import by.devincubator.entities.User;
import by.devincubator.services.user.dto.UserStatisticDTO;
import by.devincubator.services.user.exceptions.StatisticIdIsIncorrectException;
import by.devincubator.services.user.interfaces.StatisticService;
import by.devincubator.services.user.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;
    @Autowired
    private UserService userService;

    @Override
    public Statistic findById(Integer id) {
        return statisticRepository.findById(id)
                .orElseThrow(
                        () -> new StatisticIdIsIncorrectException(id)
                );
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
