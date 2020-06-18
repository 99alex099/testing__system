package by.devincubator.dits.controllers.admin;

import by.devincubator.dits.services.admin.admininterfaces.QuestionsStatisticsService;
import by.devincubator.dits.services.admin.admininterfaces.TestStatisticsService;
import by.devincubator.dits.services.admin.admininterfaces.UserStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StatisticsController {

    private TestStatisticsService testStatisticsService;
    private QuestionsStatisticsService questionsStatisticsService;
    private UserStatisticsService userStatisticsService;

    @Autowired
    public void setTestStatisticsService(TestStatisticsService testStatisticsService) {
        this.testStatisticsService = testStatisticsService;
    }

    @Autowired
    public void setQuestionsStatisticsService(QuestionsStatisticsService questionsStatisticsService) {
        this.questionsStatisticsService = questionsStatisticsService;
    }

    @Autowired
    public void setUserStatisticsService(UserStatisticsService userStatisticsService) {
        this.userStatisticsService = userStatisticsService;
    }

    @GetMapping(value = "/statisticsOptions")
    public ModelAndView getStatisticsOptionsPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPages/statisticsOptions");
        return modelAndView;
    }

    @GetMapping(value = "/testStatistics")
    public ModelAndView getTestStatisticsPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("statisticsDTOList", testStatisticsService.calculateAllTestsStatistics());
        modelAndView.setViewName("adminPages/testStatistics");
        return modelAndView;
    }

    @GetMapping(value = "/questionStatistics")
    public ModelAndView getQuestionStatisticPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("questionDTOList", questionsStatisticsService.calculateAllQuestionStatistics());
        modelAndView.setViewName("adminPages/questionStatistics");
        return modelAndView;
    }

    @GetMapping(value = "/usersStatistics")
    public ModelAndView getUserStatisticsPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userStatisticsDTOList", userStatisticsService.calculateAllUserTestsStatistics());
        modelAndView.setViewName("adminPages/userStatistics");
        return modelAndView;
    }
}