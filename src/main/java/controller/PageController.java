package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class PageController {

    @GetMapping(value = {"/", "/home","/index"})
    public String index() {
        return "index";
    }

    @GetMapping ("/test")
    public String test(@RequestParam (value = "greeting", required = false) String greeting, Model model) {
        if (greeting == null) {
            greeting = "hello there";
        }
        model.addAttribute("greeting", greeting);
        return "test";
    }
}
