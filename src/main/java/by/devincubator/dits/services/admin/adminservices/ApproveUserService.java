package by.devincubator.dits.services.admin.adminservices;

import by.devincubator.dits.entities.User;
import by.devincubator.dits.services.admin.admindto.UserForApprovalDTO;

import java.sql.SQLException;
import java.util.List;

public interface ApproveUserService {

    void approveUser(String login) throws SQLException;

    void approveAllUsers() throws SQLException;

    List<User> getAllUnapprovedUsers();

    List<UserForApprovalDTO> getAllUnapprovedUsersDTO();
}