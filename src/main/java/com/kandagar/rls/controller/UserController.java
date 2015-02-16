package com.kandagar.rls.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kandagar.rls.model.UserModel;
import com.kandagar.rls.domain.criteria.UserSearchCriteria;
import com.kandagar.rls.extension.BaseDaoException;
import com.kandagar.rls.service.RoleService;
import com.kandagar.rls.service.UserService;

@Controller
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
    private MessageSource messageSource;
	
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public String index() {
		return "admin/index";
	}
	
	@PreAuthorize("hasRole('Administrator')")
	@RequestMapping(value = "/admin/user/get", method = RequestMethod.GET)
	public String users(Model model, UserSearchCriteria criteria) {
		model.addAttribute("user", userService.getAllPaginated(criteria));
		model.addAttribute("roleList", roleService.getAll());
		model.addAttribute("filter", criteria);
		return "admin/user/get";
	}
	
	@PreAuthorize("hasRole('Administrator')")
	@RequestMapping(value = "/admin/user/edit", method = RequestMethod.GET)
	public String addUser(Model model) {
		model.addAttribute("user", new UserModel());
		model.addAttribute("roleList", roleService.getAll());
		return "admin/user/edit";
	}
	
	@PreAuthorize("hasRole('Administrator')")
	@RequestMapping(value = "/admin/user/edit/{id}", method = RequestMethod.GET)
	public String editUser(@PathVariable Integer id, Model model) {
		model.addAttribute("user", userService.get(id));
		model.addAttribute("roleList", roleService.getAll());
		return "admin/user/edit";
	}
	
	@PreAuthorize("hasRole('Administrator')")
	@RequestMapping(value = "/admin/user/save", method = RequestMethod.POST)
	public String saveUser(@Valid UserModel user, BindingResult result, Model model, Locale locale, RedirectAttributes redirectAttributes) {
		try {
			if(userService.isEmailExist(user.getEmail()) && user.isNew())
			{
				ObjectError error = new ObjectError("division",messageSource.getMessage("existEmail",null, locale));
				result.addError(error);
			}
			if(user.getPassword()=="" && user.isNew())
			{
				ObjectError error = new ObjectError("division",messageSource.getMessage("NotEmptyPassword",null, locale));
				result.addError(error);
			}
			if(userService.isLoginExist(user.getLogin()) && user.isNew())
			{
				ObjectError error = new ObjectError("division",messageSource.getMessage("existLogin",null, locale));
				result.addError(error);
			}
			if (result.hasErrors()) {
				model.addAttribute("roleList", roleService.getAll());
				return "admin/user/edit";
			}
			if (user.isNew()) {
				userService.save(user);
				redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", messageSource.getMessage("successSaveUser",null, locale));
			}else {
				userService.update(user);
				redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", messageSource.getMessage("successUpdateUser",null, locale));
			}
		}
		catch(BaseDaoException e) {
			redirectAttributes.addFlashAttribute("ERROR_MESSAGE", messageSource.getMessage("errorSaveUser",null, locale));
		}
		return "redirect:/admin/user/get";
	}
	
	@PreAuthorize("hasRole('Administrator')")
	@RequestMapping(value = "/admin/user/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable Integer id,  Locale locale, RedirectAttributes redirectAttributes) {
		try {
			userService.remove(id);
			redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", messageSource.getMessage("successDeleteUser",null, locale));
		}
		catch(BaseDaoException e) {
			redirectAttributes.addFlashAttribute("ERROR_MESSAGE",  messageSource.getMessage("errorDeleteUser",null, locale));
		}
		return "redirect:/admin/user/get";
	}

}
