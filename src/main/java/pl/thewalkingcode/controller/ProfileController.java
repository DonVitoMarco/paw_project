package pl.thewalkingcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.thewalkingcode.model.User;
import pl.thewalkingcode.model.dto.ChargeWalletDto;
import pl.thewalkingcode.model.dto.ProfileEditDto;
import pl.thewalkingcode.service.api.UserService;
import pl.thewalkingcode.util.Utils;

import java.math.BigDecimal;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String profile(Model model) {
        String username = Utils.getCurrentUsername();
        User user = userService.find(username);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("wallet", user.getAccount().getWallet().toString());
        return "profile";
    }

    @RequestMapping(value = "/charge", method = RequestMethod.GET)
    public String getChargeWallet(Model model) {
        ChargeWalletDto chargeWalletDto = new ChargeWalletDto();
        model.addAttribute("wallet", chargeWalletDto);
        return "charge";
    }

    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    public String postChargeWallet(@ModelAttribute(value = "wallet") ChargeWalletDto chargeWalletDto) {
        User user = userService.find(Utils.getCurrentUsername());
        if (user != null) {
            BigDecimal amount = new BigDecimal(chargeWalletDto.getCharge()).add(user.getAccount().getWallet());
            user.getAccount().setWallet(amount);
            userService.update(user);
            return "redirect:/profile?charge";
        }
        return "redirect:/profile?error";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEditProfile(Model model) {
        User user = userService.find(Utils.getCurrentUsername());
        ProfileEditDto profileEditDto = new ProfileEditDto();
        profileEditDto.setEmail(user.getEmail());
        profileEditDto.setUsername(user.getUsername());
        model.addAttribute("profile", profileEditDto);
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEditProfile(@ModelAttribute(value = "profile") ProfileEditDto profileEditDto) {
        User user = userService.find(Utils.getCurrentUsername());
        if (user != null) {
            user.setEmail(profileEditDto.getEmail());
            userService.update(user);
            return "redirect:/profile?edit";
        }
        return "redirect:/edit?error";
    }

}