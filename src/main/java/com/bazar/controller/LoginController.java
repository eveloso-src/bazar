package com.bazar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bazar.model.SearchForm;
import com.bazar.repository.ProductRepository;

@Controller
public class LoginController {

	@Autowired
	ProductRepository productRepository;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String login(Model model) {
		SearchForm objetoSearch = new SearchForm();
		objetoSearch.setKeyphrase("zapatillas");
		model.addAttribute("searchForm", objetoSearch);
		model.addAttribute("products", productRepository.findAll());
		return "index";
	}

}
