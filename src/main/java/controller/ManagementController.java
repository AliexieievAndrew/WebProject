package controller;

import dto.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class ManagementController {

    @GetMapping("/products")
    public String showManageProduct(Model model) {
        model.addAttribute("title", "Manage Products");
        model.addAttribute("userClick", "manage_products");

        Product nProduct = new Product();

        nProduct.setSupplierId(1);
        nProduct.setActive(true);
        // set few of the fields
        model.addAttribute("product",nProduct);
        return "index";
    }
}
