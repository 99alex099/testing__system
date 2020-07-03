package by.devincubator.dits.controllers.admin;

import by.devincubator.dits.services.admin.admindto.UserForApprovalDTO;
import by.devincubator.dits.services.admin.adminservices.ApproveUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserApproveController {

    private ApproveUserService approveUserService;

    @Autowired
    public void setApproveUserService(ApproveUserService approveUserService) {
        this.approveUserService = approveUserService;
    }

    @GetMapping(value = "/approveUser")
    public ModelAndView getApproveUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<UserForApprovalDTO> allUnapprovedUsers = approveUserService.getAllUnapprovedUsersDTO();
        modelAndView.addObject("unapprovedUsers", allUnapprovedUsers);
        modelAndView.setViewName("adminPages/approveUser");
        return modelAndView;
    }

    @PostMapping(value = "/approveUser")
    public ModelAndView approveUser(@RequestParam(name = "userLogin") String login) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPages/approveUser");
        approveUserService.approveUser(login);
        List<UserForApprovalDTO> allUnapprovedUsers = approveUserService.getAllUnapprovedUsersDTO();
        modelAndView.addObject("unapprovedUsers", allUnapprovedUsers);
        return modelAndView;
    }

    @GetMapping(value = "/approveAllUsers")
    public ModelAndView approveAllUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPages/creationOptions");
        approveUserService.approveAllUsers();
        return modelAndView;
    }
}