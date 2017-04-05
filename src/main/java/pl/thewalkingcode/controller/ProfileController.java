package pl.thewalkingcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.thewalkingcode.model.User;
import pl.thewalkingcode.repository.UserRepository;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    @RequestMapping(method = RequestMethod.GET)
    public String profile(Model model) {
        return "profile";
    }

}
