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
    public String index(Model model) {
        model.addAttribute("title","Home");
        model.addAttribute("userClick", "home");
        return "index";
    }

    @GetMapping(value = {"/about"})
    public String about(Model model) {
        model.addAttribute("title","About");
        model.addAttribute("userClick", "about");
        return "index";
    }
    @GetMapping(value = {"/allproducts"})
    public String allProducts(Model model) {
        model.addAttribute("title","All Products");
        model.addAttribute("userClick","allproducts");
        return "index";
    }
    @GetMapping(value = {"/contact"})
    public String contact(Model model) {
        model.addAttribute("title","Contact");
        model.addAttribute("userClick","contact");
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
