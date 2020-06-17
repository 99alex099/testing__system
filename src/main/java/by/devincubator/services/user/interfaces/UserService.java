package by.devincubator.services.user.interfaces;

import by.devincubator.entities.User;
import by.devincubator.services.admin.admindto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findUserById(Integer id);
    User findByLogin(String login);
    User findByFirstNameAndLastName(String firstName, String lastName);
    User saveUser(User user);
    User saveUserDTO(UserDTO userDTO);
    User registrationUser(User user);
    void deleteUser(User user);
}
