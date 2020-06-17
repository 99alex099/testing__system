package by.devincubator.services.admin.admininterfaces;

import by.devincubator.services.admin.admindto.StatisticsDTO;

import java.util.List;

public interface QuestionsStatisticsService {

    List<StatisticsDTO> calculateAllQuestionStatistics();

}