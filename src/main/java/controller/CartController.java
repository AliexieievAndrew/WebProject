package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping("/show")
    public String getShowCart(Model model){
        model.addAttribute("title","Cart");
        model.addAttribute("userClick", "cart");

        model.addAttribute("cartLines", null);
        return "index";
    }
}
