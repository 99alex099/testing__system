package by.devincubator.dits.controllers.admin;

import by.devincubator.dits.entities.User;
import by.devincubator.dits.logger.services.LogModel;
import by.devincubator.dits.logger.services.LogService;
import by.devincubator.dits.services.admin.admindto.UserLogDTO;
import by.devincubator.dits.services.general.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/logs")
public class LogController {
    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;

    @GetMapping
    public String userList(Model model) {
        List<UserLogDTO> users = userService.findAllForLogs();
        System.out.println(users);
        model.addAttribute("users", users);
        return "/adminPages/user_list_for_logs";
    }

    @GetMapping("/{username}")
    public String getLogByUser(Model model, @PathVariable String username) throws SQLException {
        List<LogModel> logs = logService.findByUser(username);
        model.addAttribute("logs", logs);
        return "/adminPages/user_log";
    }
}
