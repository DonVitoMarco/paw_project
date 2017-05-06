package pl.thewalkingcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.thewalkingcode.model.User;
import pl.thewalkingcode.model.UserTransaction;
import pl.thewalkingcode.model.dto.SellTransactionDto;
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
        model.addAttribute("userItems", userService.getUserTransaction(Utils.getCurrentUsername()));
        return "panel";
    }

    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public String buyForm(Model model) {
        model.addAttribute("buyItem", new UserBuyItemDto());
        return "buy";
    }

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public String buyForm(@ModelAttribute("buyItem") UserBuyItemDto userBuyItemDTO) {
        User user = userService.find(Utils.getCurrentUsername());
        userTransactionService.addTransaction(userBuyItemDTO, user);
        return "redirect:/panel";
    }

    @RequestMapping(value = "/sell", method = RequestMethod.GET)
    public String getSellForm(@RequestParam(value="id") int id, Model model) {
        UserTransaction userTransaction = userTransactionService.find(id);
        SellTransactionDto sellTransactionDto = new SellTransactionDto();
        sellTransactionDto.setIdUserTranscation(userTransaction.getIdUserTranscation());
        sellTransactionDto.setCode(userTransaction.getCode());
        sellTransactionDto.setFullname(userTransaction.getFullname());
        sellTransactionDto.setAmount(userTransaction.getAmount());
        sellTransactionDto.setPrice(userTransaction.getPrice());
        sellTransactionDto.setUnit(userTransaction.getUnit());
        model.addAttribute("userTransaction", sellTransactionDto);
        return "sell";
    }

    @RequestMapping(value = "/sell", method = RequestMethod.POST)
    public String postSellForm(@ModelAttribute("userTransaction") SellTransactionDto sellTransactionDto) {
        userTransactionService.sell(sellTransactionDto);
        return "redirect:/panel";
    }

}