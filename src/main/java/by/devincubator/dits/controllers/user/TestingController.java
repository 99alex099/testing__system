package by.devincubator.dits.controllers.user;

import by.devincubator.dits.services.general.dto.UserAnswersDTO;
import by.devincubator.dits.entities.Answer;
import by.devincubator.dits.entities.Question;
import by.devincubator.dits.services.general.dto.TestPassingDTO;
import by.devincubator.dits.services.general.interfaces.AnswerService;
import by.devincubator.dits.services.general.interfaces.TestService;
import by.devincubator.dits.services.user.interfaces.TestingService;
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
    @Autowired
    private TestingService testingService;
    @Autowired
    private AnswerService answerService;

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

        List<Answer> answers = answerService.findAnswersById(userAnswersIds);

        testPassing.getQuestionsDTO().get(
                testPassing.getSelectedQuestion()
        ).setUserAnswers(answers);

        if (testingService.testHasQuestionWithoutAnswer(testPassing)) {
            return formNextQuestion(testPassing);
        } else {

            sessionStatus.setComplete();
            model.addAttribute("results", testingService.fillResultDTO(testPassing));

            testingService.saveResults(testPassing, getPrincipal());

            return "user/resultPage";
        }
    }

    @GetMapping("/previous_question")
    public String formPreviousQuestion(@ModelAttribute(name = "testPassing") TestPassingDTO testPassing) {
        testingService.previousQuestion(testPassing);
        return "redirect:/testing";
    }

    @GetMapping("/next_question")
    public String formNextQuestion(@ModelAttribute(name = "testPassing") TestPassingDTO testPassing) {
        testingService.nextQuestion(testPassing);
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
