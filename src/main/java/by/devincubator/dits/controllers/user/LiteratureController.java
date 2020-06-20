package by.devincubator.dits.controllers.user;

import by.devincubator.dits.services.general.interfaces.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/literature")
public class LiteratureController {

    @Autowired
    private LiteratureService literatureService;

    @GetMapping("{literatureId}")
    public String showLiteratureById(Model model, @PathVariable int literatureId) {
        model.addAttribute("literature", literatureService.findById(literatureId));
        return "user/literaturePage";
    }
}
