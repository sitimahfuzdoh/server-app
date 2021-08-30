/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MCC53.springsecurity.controllers;

import com.MCC53.springsecurity.models.ProductItem;
import com.MCC53.springsecurity.services.ProductItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductItemController {
    
    private ProductItemService productItemService;

    @Autowired
    public ProductItemController(ProductItemService productItemService) {
        this.productItemService = productItemService;
    }
    
    @GetMapping("/listProducts.html")
	public String showExampleView(Model model)
	{
		List<ProductItem> products = productItemService.getAllProduct();
		model.addAttribute("products", products);
		return "/listProducts.html";
	}
    @GetMapping("/")
    public String showAddProduct()
    {
    	
    	return "/addProduct.html";
    }
    
    @PostMapping("/addP")
    public String saveProduct(@RequestParam("file") MultipartFile file,
    		@RequestParam("pname") String name,
    		@RequestParam("price") int price,
    		@RequestParam("desc") String desc)
    {
    	productItemService.saveProductToDB(file, name, desc, price);
    	return "redirect:/listProducts.html";
    }
    
    @GetMapping("/deleteProd/{id}")
    public String deleteProduct(@PathVariable("id") Long id)
    {
    	
    	productItemService.deleteProductById(id);
    	return "redirect:/listProducts.html";
    }
    
    @PostMapping("/changeName")
    public String changePname(@RequestParam("id") Long id,
    		@RequestParam("newPname") String name)
    {
    	productItemService.chageProductName(id, name);
    	return "redirect:/listProducts.html";
    }
    @PostMapping("/changeDescription")
    public String changeDescription(@RequestParam("id") Long id ,
    		@RequestParam("newDescription") String description)
    {
    	productItemService.changeProductDescription(id, description);
    	return "redirect:/listProducts.html";
    }
    
    @PostMapping("/changePrice")
    public String changePrice(@RequestParam("id") Long id ,
    		@RequestParam("newPrice") int price)
    {
    	productItemService.changeProductPrice(id, price);
    	return "redirect:/listProducts.html";
    }
    
}
