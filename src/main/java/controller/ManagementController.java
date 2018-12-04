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
import java.util.*;
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

    // for manage Categories
    @GetMapping("/category")
    public String manageCategory(Model model){
        model.addAttribute("title", "Manage Products");
        model.addAttribute("userClick", "new_category");

        Category mCategory = new Category();

        model.addAttribute("category", mCategory);

        return "index";
    }

    @PostMapping("/category")
    public String handleCategorySubmission(@Valid @ModelAttribute("category") Category mCategory, BindingResult result,
                                           Model model){
        categoryService.addCategory(mCategory);
        return "redirect:/manage/products";
    }

    // returning categories for all the request mapping
//    @ModelAttribute("categories")
    public Map<String,Integer> getCategories() {
        List<Category> list = categoryService.list();
        // needs a Map<value(name)=label(id)>
        return list.stream().collect(Collectors.toMap(Category::getName,Category::getId));
    }

    @ModelAttribute("categories")
    public Map<String,String> getCategoryMap() {
        return categoryService
                .list()
                .stream()
                .collect(Collectors.toMap(c -> String.valueOf(c.getId()),Category::getName));
    }


    @PostMapping("/products")
    // BindingResult must be before Model
    // @param HttpServletRequest needs to upload file
    public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult result,
                                          Model model, HttpServletRequest request){

        if(result.hasErrors()) {

            model.addAttribute("title", "Manage Products");
            model.addAttribute("userClick", "manage_products_freemarker");
            model.addAttribute("message", "Validation failed");

            return "index";
        }

        if (mProduct.getId() == 0) {

            // creating new product
            productService.add(mProduct);
        } else {
            // updating product
            productService.update(mProduct);
        }


        // check if the user has uploaded file
        if (!mProduct.getFile().getOriginalFilename().equals("")){
            // mProduct.getFile() - getting abstract file
            // mProduct.getCode() - getting code for create file's name
            FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
        }
        return "redirect:/manage/products?operation=product";
    }

    // edit product
    @GetMapping("/{id}/product")
    public String showEditProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("title", "Manage Products");
        model.addAttribute("userClick", "manage_products_freemarker");

        Product nProduct = productService.get(id);
        nProduct.setSupplierId(1);
        model.addAttribute("product",nProduct);

        return "index";
    }

    // activating and deactivating product
    @PostMapping("/product/{id}/activation")
//    @ResponseBody //////////////////////////////////////////////////////////////////////////////
    public String handleProductActivation(@PathVariable("id") int id) {
        Product product = productService.get(id);
        boolean isActive = product.isActive();

        System.out.println("ativation: " +product.getName() + " is " + isActive);
        product.setActive(!product.isActive());
        productService.update(product);

        return "index";
    }
}
