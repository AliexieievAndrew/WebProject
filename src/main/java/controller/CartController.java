package controller;

import dto.Cart;
import dto.CartLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CartLineService;
import service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    CartLineService cartLineService;

    @GetMapping("/show")
    public String getShowCart(@RequestParam(name = "result",required = false) String result, Model model){

        if(result != null){
            switch (result){
                case "updated":
                    model.addAttribute("message","cart was updated");
                    break;
                case "error":
                    model.addAttribute("message","cart not updated: error");
                    break;
            }
        }

        model.addAttribute("title","Cart");
        model.addAttribute("userClick", "cart");

        model.addAttribute("cartLines", cartService.getCartLines());
        return "index";
    }

    @GetMapping("/{id}/update")
    public String updateCount(@PathVariable("id") int cartLineId, @RequestParam(name = "count") int count, Model model){
        String response = cartService.updateCartLine(cartLineId, count);
        return "redirect:/cart/show?" + response;
    }
}
