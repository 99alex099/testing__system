package by.devincubator.dits.services.admin.admininterfaces.impl;

import by.devincubator.dits.entities.Question;
import by.devincubator.dits.entities.Statistic;
import by.devincubator.dits.repository.QuestionRepository;
import by.devincubator.dits.repository.StatisticRepository;
import by.devincubator.dits.services.admin.admindto.StatisticsDTO;
import by.devincubator.dits.services.admin.admininterfaces.QuestionsStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class QuestionsStatisticsServiceImpl implements QuestionsStatisticsService {

    private StatisticRepository statisticRepository;
    private QuestionRepository questionRepository;

    @Autowired
    public void setStatisticRepository(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<StatisticsDTO> calculateAllQuestionStatistics() {

        List<StatisticsDTO> listOfAllQuestionStatistics = new ArrayList<>();

        List<Question> listOfQuestions = questionRepository.findAll();

        for (Question question : listOfQuestions) {

            StatisticsDTO statisticsDTO = new StatisticsDTO();

            List<Statistic> listOfParticularQuestionStatistics = findAllStatisticsEntityByQuestion(question);

            int totalPassed = listOfParticularQuestionStatistics.size();

            if (totalPassed != 0) {
                int successfullyPassed = findTotalSuccessfullyPassedQuestions(listOfParticularQuestionStatistics);
                double percentageOfCorrectAnswers = (double) successfullyPassed / totalPassed * 100;
                percentageOfCorrectAnswers = new BigDecimal(percentageOfCorrectAnswers).setScale(2, RoundingMode.HALF_UP).doubleValue();
                statisticsDTO.setName(question.getDescription());
                statisticsDTO.setTotalPassed(totalPassed);
                statisticsDTO.setPercentageOfCorrectAnswers(percentageOfCorrectAnswers);
            }
            listOfAllQuestionStatistics.add(statisticsDTO);
        }
        return listOfAllQuestionStatistics;
    }

    private List<Statistic> findAllStatisticsEntityByQuestion(Question question) {

        List<Statistic> listOfAllStatisticsByTest = statisticRepository.findAll();
        listOfAllStatisticsByTest.removeIf(q -> (!q.getQuestion().getQuestionId().equals(question.getQuestionId())));
        return listOfAllStatisticsByTest;
    }

    private int findTotalSuccessfullyPassedQuestions(List<Statistic> statisticsList) {

        statisticsList.removeIf(q -> (!q.isCorrect()));
        return statisticsList.size();
    }
}