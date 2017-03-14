package pl.thewalkingcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JavaScriptController {

    @RequestMapping(value = "websocket-conn.js", method = RequestMethod.GET)
    public String common(Model model) {
        return "websocket-conn.js";
    }

}
