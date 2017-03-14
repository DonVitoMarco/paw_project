package pl.thewalkingcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/")
public class HomeController {

    List<String> rows = new ArrayList<>();

    public HomeController() {
        rows.add("ROW1");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("rows", rows);
        return "home.html";
    }

    @RequestMapping(value = "/home2", method = RequestMethod.GET)
    public String home2(Model model) {
        model.addAttribute("rows", rows);
        return "home2.html";
    }

    public List<String> getRows() {
        return rows;
    }

    public void setRows(List<String> rows) {
        this.rows = rows;
    }

}
