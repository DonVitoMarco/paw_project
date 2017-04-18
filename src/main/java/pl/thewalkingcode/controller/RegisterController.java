package pl.thewalkingcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.thewalkingcode.model.dto.NewUserDto;
import pl.thewalkingcode.repository.GenericDao;
import pl.thewalkingcode.service.api.UserService;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String registerGet(Model model) {
        NewUserDto newUserDto = new NewUserDto();
        model.addAttribute("newUserDto", newUserDto);
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerPost(@ModelAttribute("newUserDto") NewUserDto newUserDto) {
        userService.createUser(newUserDto);
        return "login";
    }

}
