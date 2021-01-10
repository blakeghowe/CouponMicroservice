package io.blakehowe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import io.blakehowe.model.Product;
import io.blakehowe.repos.ProductRepo;

@Controller
public class ProductController {

	@Autowired
	private ProductRepo repo;
	
	@GetMapping("/showCreateProduct")
	public String showCreateProduct() {
		return "createProduct";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(Product product) {
		repo.save(product);
		return "createResponse";
	}
	
	@GetMapping("/showGetProduct")
	public String showGetProduct() {
		return "getProduct";
	}
	
	@PostMapping("/getProduct")
	public ModelAndView getProduct(String name) {
		ModelAndView mav = new ModelAndView("productDetails");
		mav.addObject(repo.findByName(name));
		return mav;
	}
}
