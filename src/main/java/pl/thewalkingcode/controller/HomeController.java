package pl.thewalkingcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.thewalkingcode.model.User;
import pl.thewalkingcode.repository.UserRepository;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    public UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        User user = new User();
        user.setEmail("W@W .PL");
        userRepository.createUser(user);
        return "home";
    }

}
