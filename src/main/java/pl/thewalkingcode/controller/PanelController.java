package pl.thewalkingcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.thewalkingcode.model.User;
import pl.thewalkingcode.model.dto.UserBuyItemDto;
import pl.thewalkingcode.service.api.UserService;
import pl.thewalkingcode.service.api.UserTransactionService;
import pl.thewalkingcode.util.Utils;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/panel")
public class PanelController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("userTransactionService")
    private UserTransactionService userTransactionService;

    @RequestMapping(method = RequestMethod.GET)
    public String profile(Model model) {
        return "panel";
    }

    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public String buyForm(Model model) {
        UserBuyItemDto userBuyItemDTO = new UserBuyItemDto();
        model.addAttribute("buyItem", userBuyItemDTO);
        return "buy";
    }

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public String buyForm(@ModelAttribute("buyItem") UserBuyItemDto userBuyItemDTO) {
        User user = userService.find(Utils.getCurrentUsername());
        userTransactionService.addTransaction(userBuyItemDTO, user);
        return "redirect:/panel";
    }

}