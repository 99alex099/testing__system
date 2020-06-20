package by.devincubator.dits.services.general.interfaces;

import by.devincubator.dits.entities.User;
import by.devincubator.dits.services.admin.admindto.UserDTO;
import by.devincubator.dits.services.general.dto.UserInfoDTO;
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
    UserInfoDTO formUserInfoByUsername(String username);
    UserInfoDTO formGuestUserDTO();
}
