package by.devincubator.dits.controllers.user.handlers;

import by.devincubator.dits.services.general.exception.TestNotFoundedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class TestHandler {
    @ExceptionHandler(TestNotFoundedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    ModelAndView testNotFounded(final TestNotFoundedException e) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("testName", e.getTestName());
        modelAndView.addObject("topic", e.getSelectedTopic());
        modelAndView.setViewName("incorrectTestPage");

        return modelAndView;
    }
}
