package com.bazar.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
}
