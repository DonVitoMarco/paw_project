package pl.thewalkingcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/")
public class HomeController {

    List<String> rows = new ArrayList<>();

    public HomeController() {
        rows.add("ROW1");
        rows.add("ROW2");
        rows.add("ROW3");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("rows", rows);
        return "home";
    }

    public List<String> getRows() {
        return rows;
    }

    public void setRows(List<String> rows) {
        this.rows = rows;
    }

}
