package by.devincubator.dits.services.admin.admininterfaces;

import by.devincubator.dits.services.admin.admindto.UserStatisticsDTO;

import java.util.List;

public interface UserStatisticsService {

    List<UserStatisticsDTO> calculateAllUserTestsStatistics();

}