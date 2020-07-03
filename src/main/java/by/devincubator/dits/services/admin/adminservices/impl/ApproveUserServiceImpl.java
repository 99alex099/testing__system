package by.devincubator.dits.services.admin.adminservices.impl;

import by.devincubator.dits.entities.User;
import by.devincubator.dits.repository.UserRepository;
import by.devincubator.dits.services.admin.admindto.UserForApprovalDTO;
import by.devincubator.dits.services.admin.adminservices.ApproveUserService;
import by.devincubator.dits.services.admin.adminservices.EmailSenderService;
import by.devincubator.dits.services.general.exception.UserNotFoundByLoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ApproveUserServiceImpl implements ApproveUserService {

    private UserRepository userRepository;
    private EmailSenderService emailSenderService;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setEmailSenderService(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @Override
    public void approveUser(String login) {
        User user = userRepository.findByLogin(login).
                orElseThrow(() -> new UserNotFoundByLoginException("There is no user with such login."));
        user.setApproved(true);
        String fullName = getFullName(user);
        emailSenderService.sendEmail(fullName, user.getEmail());
    }

    @Override
    public void approveAllUsers() {
        List<User> listOfUnapprovedUsers = getAllUnapprovedUsers();
        listOfUnapprovedUsers.stream()
                .forEach(u -> approveUser(u.getLogin()));
    }

    @Override
    public List<User> getAllUnapprovedUsers() {
        return userRepository.findAllUnapprovedUsers();
    }

    @Override
    public List<UserForApprovalDTO> getAllUnapprovedUsersDTO() {

        List<User> allUnapprovedUsers = getAllUnapprovedUsers();

        List<UserForApprovalDTO> unapprovedUsers = new ArrayList<>();

        allUnapprovedUsers.forEach(u -> {
            String fullName = getFullName(u);
            unapprovedUsers.add(new UserForApprovalDTO(fullName, u.getLogin(), u.getEmail()));
        });
        return unapprovedUsers;
    }

    private String getFullName(User user){
        return user.getLastName().concat(" ").concat(user.getFirstName()).concat(" ").concat(user.getPatronymic());
    }

}