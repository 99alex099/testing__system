package by.devincubator.services.general.implementations;

import by.devincubator.repository.RoleRepository;
import by.devincubator.repository.UserRepository;
import by.devincubator.entities.Role;
import by.devincubator.entities.User;
import by.devincubator.services.admin.admindto.UserDTO;
import by.devincubator.services.general.exceptions.*;
import by.devincubator.services.general.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public User findUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserIdIsIncorrectException(id));
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login)
                .orElseThrow(() -> new UserNotFoundByLoginException(login));
    }

    @Override
    public User findByFirstNameAndLastName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(() -> new UserNotFoundByFirstNameAndLastNameException(
                        firstName, lastName
                ));
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User registrationUser(User user) {

        if (!userRepository.existsByLogin(user.getLogin())) {

            user = userRepository.save(user);

            List<Role> roles = new LinkedList<>();
            roles.add(roleRepository.findByRoleName("ROLE_USER"));

            user.setRoleList(roles);
            return userRepository.save(user);
        } else {
            throw new UserNameExistsException(user.getLogin());
        }
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User saveUserDTO(UserDTO userDTO) {

        try {
            User user = findByLogin(userDTO.getLogin());
            if (user != null) {
                throw new UserAlreadyExistsException("User with the login " + userDTO.getLogin() + " already exists");
            }
        } catch (UserNotFoundByLoginException e) {
        }

        User userForSaving = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .patronymic(userDTO.getPatronymic())
                .login(userDTO.getLogin())
                .password(bCryptPasswordEncoder.encode(userDTO.getPassword()))
                .isApproved(true)
                .email(userDTO.getEmail())
                .roleList(userDTO.getRoleList())
                .build();

        return userRepository.save(userForSaving);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = userRepository.findByLogin(username).orElseThrow(()
                -> new UsernameNotFoundException(username));
        user.setPassword(encoder.encode(user.getPassword()));
        return user;
    }
}
