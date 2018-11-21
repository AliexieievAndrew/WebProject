package controller;

import dao.ProductDAO;
import dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

    @Autowired
    ProductDAO productDAO;

    @GetMapping("/all/products")
    @ResponseBody // help to complete response to JSON (when added dependency)
    public List<Product> getAllProducts() {
        return productDAO.listActiveProducts();
    }

    @GetMapping("/category/{id}/products")
    @ResponseBody
    public List<Product> getProductsByCategory(@PathVariable int id) {
        return productDAO.listActiveProductsByCategory(id);
    }
}
