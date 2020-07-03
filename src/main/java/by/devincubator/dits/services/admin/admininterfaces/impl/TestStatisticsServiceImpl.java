package by.devincubator.dits.services.admin.admininterfaces.impl;

import by.devincubator.dits.entities.Statistic;
import by.devincubator.dits.entities.Test;
import by.devincubator.dits.repository.StatisticRepository;
import by.devincubator.dits.repository.TestRepository;
import by.devincubator.dits.services.admin.admindto.StatisticsDTO;
import by.devincubator.dits.services.admin.admininterfaces.TestStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class TestStatisticsServiceImpl implements TestStatisticsService {

    private TestRepository testRepository;
    private StatisticRepository statisticRepository;

    @Autowired
    public void setTestRepository(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Autowired
    public void setStatisticRepository(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Override
    public List<StatisticsDTO> calculateAllTestsStatistics() {

        List<StatisticsDTO> listOfAllTestStatistics = new ArrayList<>();

        List<Test> listOfTests = testRepository.findAll();

        for (Test test : listOfTests) {

            StatisticsDTO statisticsDTO = new StatisticsDTO();
            int totalPassed = findTotalPassedQuestions(test);
            int quantityOfTestsAttempts = totalPassed / test.getQuestions().size();

            if (quantityOfTestsAttempts != 0) {
                double percentageOfCorrectAnswers = (double) findTotalSuccessfullyPassedQuestions(test) / totalPassed * 100;
                percentageOfCorrectAnswers = new BigDecimal(percentageOfCorrectAnswers).setScale(2, RoundingMode.HALF_UP).doubleValue();
                statisticsDTO.setTotalPassed(quantityOfTestsAttempts);
                statisticsDTO.setPercentageOfCorrectAnswers(percentageOfCorrectAnswers);
            }
            statisticsDTO.setName(test.getName());
            listOfAllTestStatistics.add(statisticsDTO);
        }
        return listOfAllTestStatistics;
    }

    private List<Statistic> findAllStatisticsEntityByTest(Test test) {

        List<Statistic> listOfAllStatisticsByTest = statisticRepository.findAll();
        listOfAllStatisticsByTest.removeIf(s -> (!s.getQuestion().getTest().getTestId().equals(test.getTestId())));

        return listOfAllStatisticsByTest;
    }

    private int findTotalPassedQuestions(Test test) {

        List<Statistic> listOfAllStatisticsByTest = findAllStatisticsEntityByTest(test);
        return listOfAllStatisticsByTest.size();

    }

    private int findTotalSuccessfullyPassedQuestions(Test test) {

        List<Statistic> listOfAllStatisticsByTest = findAllStatisticsEntityByTest(test);
        listOfAllStatisticsByTest.removeIf(s -> (!s.isCorrect()));

        return listOfAllStatisticsByTest.size();

    }
}