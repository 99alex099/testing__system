package by.devincubator.dits.services.admin.adminservices.impl;

import by.devincubator.dits.entities.Statistic;
import by.devincubator.dits.entities.Test;
import by.devincubator.dits.entities.User;
import by.devincubator.dits.repository.StatisticRepository;
import by.devincubator.dits.repository.TestRepository;
import by.devincubator.dits.repository.UserRepository;
import by.devincubator.dits.services.admin.admindto.UserStatisticsDTO;
import by.devincubator.dits.services.admin.adminservices.UserStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserStatisticsServiceImpl implements UserStatisticsService {

    private UserRepository userRepository;
    private TestRepository testRepository;
    private StatisticRepository statisticRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setTestRepository(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Autowired
    public void setStatisticRepository(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Override
    public List<UserStatisticsDTO> calculateAllUserTestsStatistics() {

        List<UserStatisticsDTO> listOfUserStatisticsDTO = new ArrayList<>();

        List<User> listOfAllUsers = userRepository.findAll();
        List<Test> listOfAllTests = testRepository.findAll();

        for (User user : listOfAllUsers) {

            String fullName = user.getLastName().concat(" ").concat(user.getFirstName()).concat(" ").concat(user.getPatronymic());

            for (Test test : listOfAllTests) {

                int totalPassed = findTotalPassedQuestions(test, user);
                if (totalPassed != 0) {

                    double percentageOfCorrectAnswers = (double) findTotalSuccessfullyPassedQuestions(test, user) / totalPassed * 100;
                    percentageOfCorrectAnswers = new BigDecimal(percentageOfCorrectAnswers).setScale(2, RoundingMode.HALF_UP).doubleValue();
                    int quantityOfTestsAttempts = findTotalAttemptsQuantity(test, user);

                    UserStatisticsDTO userStatisticsDTO = new UserStatisticsDTO();
                    userStatisticsDTO.setFullName(fullName);
                    userStatisticsDTO.setName(test.getName());
                    userStatisticsDTO.setTotalPassed(quantityOfTestsAttempts);
                    userStatisticsDTO.setPercentageOfCorrectAnswers(percentageOfCorrectAnswers);
                    listOfUserStatisticsDTO.add(userStatisticsDTO);
                }
            }
        }
        return listOfUserStatisticsDTO;
    }

    private List<Statistic> findAllStatisticsEntityByTestAndByUser(Test test, User user) {
        List<Statistic> listOfAllStatisticsByTestAndByUser = statisticRepository.findAll();
        listOfAllStatisticsByTestAndByUser.removeIf(s -> (!s.getQuestion().getTest().getTestId().equals(test.getTestId())));
        listOfAllStatisticsByTestAndByUser.removeIf(s -> (!s.getUser().getUserId().equals(user.getUserId())));
        return listOfAllStatisticsByTestAndByUser;
    }

    private int findTotalPassedQuestions(Test test, User user) {
        List<Statistic> listOfAllStatisticsByTestAndUser = findAllStatisticsEntityByTestAndByUser(test, user);
        return listOfAllStatisticsByTestAndUser.size();
    }

    private int findTotalSuccessfullyPassedQuestions(Test test, User user) {
        List<Statistic> listOfAllStatisticsByTest = findAllStatisticsEntityByTestAndByUser(test, user);
        listOfAllStatisticsByTest.removeIf(s -> (!s.isCorrect()));
        return listOfAllStatisticsByTest.size();
    }

    private int getIdOfFirstQuestionOfTheTest(Test test) {
        return test.getQuestions().get(0).getQuestionId();
    }

    private int findTotalAttemptsQuantity(Test test, User user) {
        List<Statistic> listOfAllStatisticsByTestAndByUser = findAllStatisticsEntityByTestAndByUser(test, user);
        int firstQuestionId = getIdOfFirstQuestionOfTheTest(test);

        return (int) listOfAllStatisticsByTestAndByUser.stream()
                .filter(s -> s.getQuestion().getQuestionId() == firstQuestionId)
                .count();
    }
}