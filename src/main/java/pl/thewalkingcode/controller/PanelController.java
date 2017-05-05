package pl.thewalkingcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.thewalkingcode.model.dto.UserBuyItemDto;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/panel")
public class PanelController {

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
        System.out.println(userBuyItemDTO.toString());
        return "redirect:/panel";
    }

}