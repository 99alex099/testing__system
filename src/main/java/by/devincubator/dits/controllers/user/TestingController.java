package by.devincubator.dits.controllers.user;

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
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/testing")
@SessionAttributes(types = {TestPassingDTO.class},
        value = {"selectedAnswers", "results"})
public class TestingController {

    @Autowired
    private TestingService testingService;
    @Autowired
    private AnswerService answerService;

    @GetMapping
    public String formQuestion(Model model,
                               @ModelAttribute(name = "testPassing") TestPassingDTO testPassing) {

        Question question = testPassing.getQuestionsDTO().get(
                testPassing.getSelectedQuestion()
        ).getQuestion();

        model.addAttribute("question", question.getDescription());
        model.addAttribute("selectableAnswers", question.getAnswers());

        return "user/questionPage";

    }

    @PostMapping
    @Transactional
    public String saveUserAnswers(Model model,
                                  @ModelAttribute(name = "testPassing") TestPassingDTO testPassing,
                                  @RequestParam("userAnswersIds") List<Integer> userAnswersIds) throws SQLException {

        List<Answer> answers = answerService.findAnswersById(userAnswersIds);

        testPassing.getQuestionsDTO().get(
                testPassing.getSelectedQuestion()
        ).setUserAnswers(answers);

        if (testingService.testHasQuestionWithoutAnswer(testPassing)) {
            return formNextQuestion(testPassing);
        } else {

            model.addAttribute("result", testingService.fillResultDTO(testPassing));
            testingService.saveResults(testPassing, getPrincipal());

            return "redirect:/testing/result";
        }
    }

    @GetMapping("/result")
    public String formResultPage(Model model,
                                 @ModelAttribute(name = "testPassing") TestPassingDTO testPassing) {
        System.out.println(testingService.fillResultDTO(testPassing));
        model.addAttribute("result", testingService.fillResultDTO(testPassing));
        return "user/resultPage";
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
