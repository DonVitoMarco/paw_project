package pl.thewalkingcode.controller;

import org.hibernate.boot.jaxb.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.thewalkingcode.model.User;
import pl.thewalkingcode.service.api.UserService;
import pl.thewalkingcode.util.Utils;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String profile(Model model) {
        String username = Utils.getCurrentUsername();
//        User user = userService.find(username);
//        model.addAttribute("username", user.getUsername());
//        model.addAttribute("wallet", user.getAccount().getWallet().toString());
        return "profile";
    }

}