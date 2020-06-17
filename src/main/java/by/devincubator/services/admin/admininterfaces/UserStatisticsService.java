package by.devincubator.services.admin.admininterfaces;

import by.devincubator.services.admin.admindto.UserStatisticsDTO;

import java.util.List;

public interface UserStatisticsService {

    List<UserStatisticsDTO> calculateAllUserTestsStatistics();

}