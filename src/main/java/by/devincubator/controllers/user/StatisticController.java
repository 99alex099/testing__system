package by.devincubator.controllers.user;

import by.devincubator.services.general.interfaces.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import by.devincubator.entities.Statistic;

import java.util.List;

@Controller
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

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

    @GetMapping("/my_statistic")
    public String showStatistic(Model model) {

        List<Statistic> userStatistic = statisticService.findByUsername(getPrincipal());

        model.addAttribute("statistics",
                statisticService.convertToUserStatisticDTO(userStatistic));

        return "user/statisticPage";
    }

}
