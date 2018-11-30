package controller;

import dto.Category;
import dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.CategoryService;
import service.ProductService;
import util.FileUploadUtility;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/manage")
public class ManagementController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String showManageProduct(@RequestParam(name = "operation",required = false) String operation, Model model) {
        model.addAttribute("title", "Manage Products");
        model.addAttribute("userClick", "manage_products_freemarker");

        Product nProduct = new Product();

        nProduct.setSupplierId(1);
//        nProduct.setActive(true);

        // set few of the fields
        model.addAttribute("product",nProduct);

        if (operation!= null) {
            if (operation.equals("product")){
                model.addAttribute("message", "element successfully added");
            }
        }

        return "index";
    }

    // returning categories for all the request mapping
    @ModelAttribute("categories")
    public Map<String,Integer> getCategories() {
        List<Category> list = categoryService.list();
        // needs a Map<value(name)=label(id)>
        return list.stream().collect(Collectors.toMap(Category::getName,Category::getId));
    }

    @PostMapping("/products")
    // BindingResult must be before Model
    // @param HttpServletRequest needs to upload file
    public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult result,
                                          Model model, HttpServletRequest request){
        System.out.println("get all errors: " + result.getAllErrors());
        //check if there are any errors
        if(result.hasErrors()) {
            System.out.println("has errors");

            model.addAttribute("title", "Manage Products");
            model.addAttribute("userClick", "manage_products_freemarker");
            model.addAttribute("message", "Validation failed");

            return "index";
        }
        System.out.println("Product added successfully: " + mProduct.toString());
        productService.add(mProduct);

        // check if the user has uploaded file
        if (!mProduct.getFile().getOriginalFilename().equals("")){

            // mProduct.getFile() - getting abstract file
            // mProduct.getCode() - getting code for create file's name
            FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
        }
        return "redirect:/manage/products?operation=product";
    }
}
