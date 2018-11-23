package controller;

import dao.ProductDAO;
import dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

    @Autowired
    ProductService productService;

    @GetMapping("/all/products")
    @ResponseBody // help to complete response to JSON (when added dependency)
    public List<Product> getAllProducts() {
        return productService.listActiveProducts();
    }

    @GetMapping("/category/{id}/products")
    @ResponseBody
    public List<Product> getProductsByCategory(@PathVariable int id) {
        return productService.listActiveProductsByCategory(id);
    }
}
