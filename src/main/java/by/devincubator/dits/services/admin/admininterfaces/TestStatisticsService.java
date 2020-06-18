package by.devincubator.dits.services.admin.admininterfaces;

import by.devincubator.dits.services.admin.admindto.StatisticsDTO;

import java.util.List;

public interface TestStatisticsService {

    List<StatisticsDTO> calculateAllTestsStatistics();

}