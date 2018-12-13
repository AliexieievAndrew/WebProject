package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import dto.*;
import exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CategoryService;
import service.ProductService;
import service.UserService;

import java.util.List;


@Controller
@RequestMapping("/")
public class PageController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @GetMapping(value = {"/", "/home","/index"})
    public String index(Model model) {
        model.addAttribute("title","Home");
        model.addAttribute("userClick", "home");

        // passing the list of categories
        model.addAttribute("categories", categoryService.list());

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
        model.addAttribute("categories", categoryService.list());
        model.addAttribute("title", "All Products");
        model.addAttribute("userClick","allproducts");
        return "index";
    }

    // get products by category
    @GetMapping(value = "/show/category/{id}/products")
    public String getCategoryProducts(@PathVariable("id") int id, Model model) {
        Category category = null;
        category = categoryService.get(id);

        model.addAttribute("title", category.getName());

        // passing the list of categories
        model.addAttribute("categories", categoryService.list());

        // passing th category
        model.addAttribute("category", category);

        model.addAttribute("userClick","allproducts");

        return "index";
    }

    // View a single product
    @GetMapping(value = "/show/{id}/product")
    public String getProductById(@PathVariable("id") int id, Model model) throws ProductNotFoundException {
        Product product = productService.get(id);

        if(product == null)
            throw new ProductNotFoundException();

        model.addAttribute("title", product.getName());
        model.addAttribute("product",product);
        model.addAttribute("userClick","single_product");

        return "index";
    }

    // Register new user
    @GetMapping(value = {"/register"})
    public String register(Model model) {
        model.addAttribute("title","register");
        model.addAttribute("userClick", "about");
        return "index";
    }

    // login
    @GetMapping(value = {"/login"})
    public String login(@RequestParam(name ="error", required = false)String error, Model model) {

        if(error != null) {
            model.addAttribute("message", "invalid username or password");
        }

        model.addAttribute("title","login");
        model.addAttribute("userClick", "login");
        return "index";
    }

    // Access Denied
    @GetMapping("/accessDenied")
    public String accessDeniedException(Model model){
        model.addAttribute("errorTitle", "accessDenied");
        model.addAttribute("errorDescription","access Denied now :(");
        model.addAttribute("title", "access Denied");
        return "error";
    }

//    only for testing
//    @GetMapping ("/test")
    public String test(@RequestParam (value = "greeting", required = false) String greeting, Model model) {

        // 1. Create User
        User user = new User();

        user.setFirstName("andrew");
        user.setLastName("alexeev");
        user.setRole("user");
        user.setPassword("12345");
        user.setEmail("AndrewBEST@ukr.net");
        user.setContactNumber("555222111");

        // 1.1 create Cart
        Cart cart = new Cart();

        // 1.2 set User and set Cart
        cart.setUser(user);
        user.setCart(cart);

        // 1.3 add User to DB
        userService.addUser(user);

        // 3. create Address
        Address address = new Address();
        address.setAddressLine("some delivery street");
        address.setAddressDescription("some delivery description");
        address.setCity("Kyiv");
        address.setCountry("Ukraine");

        // 3.1 set User
        address.setUser(user);


        // 2.2 add address to DB
//        userService.addAddress(address);


        // get address List by user
//        List<Address> addressList= userService.getDeliveryAddresses(user);

//        addressList.stream().forEach(e -> System.out.println(e));

        // 4 Edit Cart example

//        User user = userService.getByEmail("Gosha@ukr.net");
//        Cart cart = user.getCart();
//
//        System.out.println("user:" + user);
//        System.out.println("cart:" + cart);
//
//        cart.setTotal(555.55);
//        cart.setCartLines(2);
//
//        userService.updateCart(cart);


        if (greeting == null) {
            greeting = "hello there";
        }


        model.addAttribute("greeting", greeting);
        return "test";
    }
}
