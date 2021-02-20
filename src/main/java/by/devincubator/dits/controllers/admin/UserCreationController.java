package by.devincubator.dits.controllers.admin;

import by.devincubator.dits.entities.Role;
import by.devincubator.dits.services.admin.admindto.UserDTO;
import by.devincubator.dits.services.general.exception.InvalidRoleListException;
import by.devincubator.dits.services.general.interfaces.RoleService;
import by.devincubator.dits.services.general.interfaces.UserService;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserCreationController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(value = "/createUser")
    public ModelAndView createUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roles", roleService.findAllRoles()
                .stream()
                .map(Role::getRoleName)
                .map(r -> r.replace("ROLE_", ""))
                .collect(Collectors.toList()));
        modelAndView.addObject("userDTO", new UserDTO());
        modelAndView.setViewName("adminPages/createUser");
        return modelAndView;
    }

    @PostMapping(value = "/createUser")
    public ModelAndView createUser(@Valid @ModelAttribute("userDTO") UserDTO userDTO,
                                   @RequestParam(value = "rolll", required = false) List<String> chosenRole) throws SQLException {

        ModelAndView modelAndView = new ModelAndView();

        if (chosenRole == null) {
            throw new InvalidRoleListException("Некорректный список ролей.\\nПроверьте свой выбор и попробуйте снова.");
        }

        List<Role> listOfUsersRole = userService.getRoleListForUserDTO(chosenRole);

        userDTO.setRoleList(listOfUsersRole);
        userService.saveUserDTO(userDTO);

        modelAndView.setViewName("adminPages/creationOptions");
        return modelAndView;
    }
}