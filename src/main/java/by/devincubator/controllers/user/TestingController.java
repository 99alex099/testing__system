package by.devincubator.controllers.user;

import by.devincubator.entities.Answer;
import by.devincubator.entities.Question;
import by.devincubator.services.user.dto.TestPassingDTO;
import by.devincubator.services.user.dto.UserAnswersDTO;
import by.devincubator.services.user.interfaces.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/testing")
@SessionAttributes(types = {TestPassingDTO.class, UserAnswersDTO.class},
        value = {"selectedAnswers"})
public class TestingController {

    @Autowired
    private TestService testService;

    @GetMapping
    public String formQuestion(Model model,
                               @ModelAttribute(name = "testPassing") TestPassingDTO testPassing) {

        UserAnswersDTO userAnswersDTO = new UserAnswersDTO();

        Question question = testPassing.getQuestionsDTO().get(
                testPassing.getSelectedQuestion()
        ).getQuestion();

        model.addAttribute("question", question.getDescription());
        model.addAttribute("userAnswers", userAnswersDTO);
        model.addAttribute("selectableAnswers", question.getAnswers());

        return "user/questionPage";

    }

    @PostMapping
    @Transactional
    public String checkAnswer(Model model,
                              @ModelAttribute(name = "testPassing") TestPassingDTO testPassing,
                              @RequestParam("userAnswersIds") List<Integer> userAnswersIds,
                              SessionStatus sessionStatus) {

        List<Answer> answers = testService.findAnswersById(userAnswersIds);

        testPassing.getQuestionsDTO().get(
                testPassing.getSelectedQuestion()
        ).setUserAnswers(answers);

        if (testService.testHasQuestionWithoutAnswer(testPassing)) {
            return formNextQuestion(testPassing);
        } else {

            sessionStatus.setComplete();
            model.addAttribute("results", testService.fillResultDTO(testPassing));

            testService.saveResults(testPassing, getPrincipal());

            return "user/resultPage";
        }
    }

    @GetMapping("/previous_question")
    public String formPreviousQuestion(@ModelAttribute(name = "testPassing") TestPassingDTO testPassing) {
        testService.previousQuestion(testPassing);
        return "redirect:/testing";
    }

    @GetMapping("/next_question")
    public String formNextQuestion(@ModelAttribute(name = "testPassing") TestPassingDTO testPassing) {
        testService.nextQuestion(testPassing);
        return "redirect:/testing";
    }

    private static String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
