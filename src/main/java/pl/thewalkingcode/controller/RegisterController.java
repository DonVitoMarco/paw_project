package pl.thewalkingcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.thewalkingcode.repository.GenericDao;
import pl.thewalkingcode.service.api.UserService;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    public UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String registerGet(Model model) {
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerPost(Model model) {
        return "login";
    }

}
