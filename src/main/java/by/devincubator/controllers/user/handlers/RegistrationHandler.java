package by.devincubator.controllers.user.handlers;

import by.devincubator.services.general.exceptions.UserNameExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class RegistrationHandler {
    @ExceptionHandler(UserNameExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ModelAndView usernameExists(final UserNameExistsException e) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", e.getUsername());
        modelAndView.setViewName("incorrectUsernamePage");

        return modelAndView;
    }
}
