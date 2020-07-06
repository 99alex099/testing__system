package by.devincubator.dits.controllers.admin.handlers;

import by.devincubator.dits.entities.Role;
import by.devincubator.dits.services.general.exception.EmailIsNotValidException;
import by.devincubator.dits.services.general.exception.InvalidRoleListException;
import by.devincubator.dits.services.general.exception.UserAlreadyExistsException;
import by.devincubator.dits.services.general.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionController {

    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ModelAndView handleUserNotFoundByLoginException(UserAlreadyExistsException e) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("adminPages/createUser");
        modelAndView.addObject("loginExists", "Пользователь с таким логином уже существует.\nПопробуйте снова.");

        return modelAndView;
    }


    @ExceptionHandler(EmailIsNotValidException.class)
    public ModelAndView handleEmailIsNotValidException(EmailIsNotValidException e) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("roles", roleService.findAllRoles()
                .stream()
                .map(Role::getRoleName)
                .map(r -> r.replace("ROLE_", ""))
                .collect(Collectors.toList()));

        modelAndView.setViewName("adminPages/createUser");
        modelAndView.addObject("incorrectEmail", "Некорректный email.\nПопробуйте снова.");

        return modelAndView;
    }

    @ExceptionHandler(InvalidRoleListException.class)
    public ModelAndView handleInvalidRoleListException(InvalidRoleListException e) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("roles", roleService.findAllRoles()
                .stream()
                .map(Role::getRoleName)
                .map(r -> r.replace("ROLE_", ""))
                .collect(Collectors.toList()));

        modelAndView.setViewName("adminPages/createUser");
        modelAndView.addObject("invalidRoleList", "Некорректный список ролей.\nПроверьте свой выбор и Попробуйте снова.");

        return modelAndView;
    }

    @ExceptionHandler(DisabledException.class)
    public ModelAndView handleDisableException(DisabledException e) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("login");
        modelAndView.addObject("disable", "Ваш аккаунт не подтвержден.\nОбратитесь к вашему админимтратору.");

        return modelAndView;
    }
}