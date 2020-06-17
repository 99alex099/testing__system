package by.devincubator.services.admin.admininterfaces;

import by.devincubator.services.admin.admindto.StatisticsDTO;

import java.util.List;

public interface TestStatisticsService {

    List<StatisticsDTO> calculateAllTestsStatistics();

}