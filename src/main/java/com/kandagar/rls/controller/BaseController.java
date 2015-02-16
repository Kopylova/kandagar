package com.kandagar.rls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("pages/SystemError");
		model.addObject("message", ex.getMessage());
		model.addObject("stackTrace", ex.getStackTrace());

		return model;

	}

}
