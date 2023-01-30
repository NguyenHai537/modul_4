package com.codegym.controller;


import com.codegym.model.Product;
import com.codegym.model.ProductSearch;
import com.codegym.service.IProductService;
import com.codegym.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private IProductService iProductService = new ProductServiceImpl();

    @GetMapping("")
    public String index(Model model){
    List<Product> products = iProductService.findAll();
    model.addAttribute("products" , products);
    return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product){
    product.setId((int) (Math.random() * 10000));
    iProductService.create(product);
    return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id , Model model){
    model.addAttribute("product",iProductService.findByID(id));
    return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes){
        iProductService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("message", "updated successfully");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("product", iProductService.findByID(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product , RedirectAttributes redirectAttributes){
        iProductService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message","deleted successfully");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findByID(id));
        return "/view";
    }

    @PostMapping("/search")
    public String search(ProductSearch productSearch, Model model){
        List<Product> products = iProductService.findByName(productSearch.getKeyword());
        model.addAttribute("products" , products);
        return "/index";
    }
}


