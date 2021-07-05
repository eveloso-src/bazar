package com.bazar.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bazar.repository.ProductRepository;

@Controller
public class LoginController {

	@Autowired
	ProductRepository productRepository;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addObject("products", productRepository.findAll());
		return modelAndView;
	}
}
