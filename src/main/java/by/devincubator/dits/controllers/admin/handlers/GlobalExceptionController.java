package by.devincubator.dits.controllers.admin.handlers;

import by.devincubator.dits.services.general.exception.EmailIsNotValidException;
import by.devincubator.dits.services.general.exception.UserAlreadyExistsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {

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

        modelAndView.setViewName("adminPages/createUser");
        modelAndView.addObject("incorrectEmail", "Некорректный email.\nПопробуйте снова.");

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