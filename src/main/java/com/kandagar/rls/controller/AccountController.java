package com.kandagar.rls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController extends BaseController {
	@RequestMapping("/login")
	public String doLogin(){
		return "login";
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("hasErrors", "true");
		return "login";
	}
	
	@RequestMapping(value = "/admin/logon", method = RequestMethod.GET)
	public String logon() {
		return "admin/logon";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "redirect:/";
	}
}
