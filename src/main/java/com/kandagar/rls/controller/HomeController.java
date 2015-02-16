package com.kandagar.rls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kandagar.rls.domain.criteria.EducationSearchCriteria;
import com.kandagar.rls.domain.criteria.ResumeSearchCriteria;
import com.kandagar.rls.domain.criteria.RubricaSearchCriteria;
import com.kandagar.rls.domain.criteria.WorkingTypeSearchCriteria;
import com.kandagar.rls.service.EducationService;
import com.kandagar.rls.service.ResumeService;
import com.kandagar.rls.service.RubricaService;
import com.kandagar.rls.service.WorkingTypeService;

@Controller
public class HomeController extends BaseController {
	
	@Autowired
	private ResumeService resumeService;
	
	@Autowired
	private WorkingTypeService workingTypeService;
	
	@Autowired
	private EducationService educationService;
	
	@Autowired
	private RubricaService rubricaService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String resumes(Model model, ResumeSearchCriteria criteria) {
		model.addAttribute("resume", resumeService.getAllPaginated(criteria));
		model.addAttribute("resumeCount", resumeService.getAllCount(criteria));
		model.addAttribute("workingTypeList", workingTypeService.getAll(new WorkingTypeSearchCriteria()));
		model.addAttribute("educationList", educationService.getAll(new EducationSearchCriteria()));
		model.addAttribute("rubricaList", rubricaService.getAll(new RubricaSearchCriteria()));
		model.addAttribute("filter", criteria);
		return "client/resume/get";
	}
	
}
