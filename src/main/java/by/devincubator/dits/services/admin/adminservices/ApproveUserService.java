package by.devincubator.dits.services.admin.adminservices;

import by.devincubator.dits.entities.User;
import by.devincubator.dits.services.admin.admindto.UserForApprovalDTO;

import java.util.List;

public interface ApproveUserService {

    void approveUser(String login);

    void approveAllUsers();

    List<User> getAllUnapprovedUsers();

    List<UserForApprovalDTO> getAllUnapprovedUsersDTO();
}