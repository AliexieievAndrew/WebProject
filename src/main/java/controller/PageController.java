package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import dto.Category;
import dto.Product;
import exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class PageController {

    @Autowired
    CategoryDAO categoryDAO;

    // временно
    @Autowired
    ProductDAO productDAO;

    @GetMapping(value = {"/", "/home","/index"})
    public String index(Model model) {
        model.addAttribute("title","Home");
        model.addAttribute("userClick", "home");

        // passing the list of categories
        model.addAttribute("categories", categoryDAO.list());

        return "index";
    }

    @GetMapping(value = {"/about"})
    public String about(Model model) {
        model.addAttribute("title","About");
        model.addAttribute("userClick", "about");
        return "index";
    }
    // no relevant to delete
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

    // Get all products and based on category
    @GetMapping(value = "/show/all/products")
    public String getAllProducts(Model model){
        model.addAttribute("categories", categoryDAO.list());
        model.addAttribute("title", "All Products");
        model.addAttribute("userClick","allproducts");
        return "index";
    }

    // get products by category
    @GetMapping(value = "/show/category/{id}/products")
    public String getCategoryProducts(@PathVariable("id") int id, Model model) {
        Category category = null;
        category = categoryDAO.get(id);

        model.addAttribute("title", category.getName());

        // passing the list of categories
        model.addAttribute("categories", categoryDAO.list());

        // passing th category
        model.addAttribute("category", category);

        model.addAttribute("userClick","allproducts");

        return "index";
    }

    // View a single product
    @GetMapping(value = "/show/{id}/product")
    public String getProductById(@PathVariable("id") int id, Model model) throws ProductNotFoundException {
        Product product = productDAO.get(id);

        if(product == null)
            throw new ProductNotFoundException();

        model.addAttribute("title", product.getName());
        model.addAttribute("product",product);
        model.addAttribute("userClick","single_product");

        return "index";
    }


    @GetMapping ("/test")
    public String test(@RequestParam (value = "greeting", required = false) String greeting, Model model) {
        Product product = productDAO.get(1);
        System.out.println("Product name = " + product.getName());

        if (greeting == null) {
            greeting = "hello there";
        }
        model.addAttribute("greeting", greeting);
        return "test";
    }
}
