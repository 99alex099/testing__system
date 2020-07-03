package by.devincubator.dits.services.admin.adminservices;

import by.devincubator.dits.services.admin.admindto.StatisticsDTO;

import java.util.List;

public interface QuestionsStatisticsService {

    List<StatisticsDTO> calculateAllQuestionStatistics();

}