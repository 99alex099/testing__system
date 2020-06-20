package by.devincubator.dits.controllers.user.handlers;

import by.devincubator.dits.services.general.exceptions.LiteratureIdIsIncorrectException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class LiteratureHandler {
    @ExceptionHandler(LiteratureIdIsIncorrectException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ModelAndView literatureIdIsIncorrect(final LiteratureIdIsIncorrectException e) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorText", e.getId());
        modelAndView.setViewName("user/errorPage");

        return modelAndView;
    }
}
