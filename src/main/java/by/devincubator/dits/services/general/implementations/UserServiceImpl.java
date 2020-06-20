package by.devincubator.dits.services.general.implementations;

import by.devincubator.dits.entities.RolesEnum;
import by.devincubator.dits.services.general.dto.UserInfoDTO;
import by.devincubator.dits.services.general.exceptions.*;
import by.devincubator.dits.repository.RoleRepository;
import by.devincubator.dits.repository.UserRepository;
import by.devincubator.dits.entities.Role;
import by.devincubator.dits.entities.User;
import by.devincubator.dits.services.admin.admindto.UserDTO;
import by.devincubator.dits.services.general.exceptions.*;
import by.devincubator.dits.services.general.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private static final UserInfoDTO GUEST = new UserInfoDTO("guest", new LinkedList<>());
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
    public UserInfoDTO formUserInfoByUsername(String username) {

        Optional<User> userOptional = userRepository.findByLogin(username);

        return userOptional.map(user -> new UserInfoDTO(username,
                user.getRoleList().stream()
                        .map(role -> RolesEnum.valueOf(role.getRoleName()))
                        .collect(Collectors.toList()))).orElseGet(this::formGuestUserDTO);
    }

    @Override
    public UserInfoDTO formGuestUserDTO() {
        return GUEST;
    }

    private UserDTO formGuestInfo() {
        return null;
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
