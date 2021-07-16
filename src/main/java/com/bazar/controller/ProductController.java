package com.bazar.controller;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bazar.model.Product;
import com.bazar.model.SearchForm;
import com.bazar.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	private static Log log = LogFactory.getLog(ProductController.class);

	@PostMapping("/search")
	public String searchProduct(Model model, @ModelAttribute SearchForm searchForm) {
		log.debug("search");
		List<Product> filterByDesc = productRepository.findByDescriptionContainingIgnoreCase(searchForm.getKeyphrase());
		model.addAttribute("searchForm", new SearchForm());
		model.addAttribute("products", filterByDesc);
		return "index";

	}

	@GetMapping("/product/{id}")
	public String detailProduct(Model model, @PathVariable String id) {
		log.debug("detail");
		Optional<Product> product = productRepository.findById(Integer.valueOf(id));
		if (product.isPresent()) {
			model.addAttribute("product", product.get());
		}
		model.addAttribute("searchForm", new SearchForm());
		return "detail";

	}

	@GetMapping("/product1")
	public String detailProduct1(Model model) {
		log.debug("detail");
		String id = "1";
		Optional<Product> product = productRepository.findById(Integer.valueOf(id));
		if (product.isPresent()) {
			model.addAttribute("product", product.get());
		}
		return "detail";

	}

}
