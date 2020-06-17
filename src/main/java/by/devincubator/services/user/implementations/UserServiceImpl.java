package by.devincubator.services.user.implementations;

import by.devincubator.repository.RoleRepository;
import by.devincubator.repository.UserRepository;
import by.devincubator.entities.Role;
import by.devincubator.entities.User;
import by.devincubator.services.user.exceptions.UserIdIsIncorrectException;
import by.devincubator.services.user.exceptions.UserNameExistsException;
import by.devincubator.services.user.exceptions.UserNotFoundByFirstNameAndLastNameException;
import by.devincubator.services.user.exceptions.UserNotFoundByLoginException;
import by.devincubator.services.user.interfaces.UserService;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = userRepository.findByLogin(username).orElseThrow(()
                -> new UsernameNotFoundException(username));
        user.setPassword(encoder.encode(user.getPassword()));
        return user;
    }
}
