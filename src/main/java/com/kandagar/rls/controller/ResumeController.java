package com.kandagar.rls.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kandagar.rls.domain.criteria.UserSearchCriteria;
import com.kandagar.rls.job.ResumeLoadJob;
import com.kandagar.rls.service.ResumeService;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


@Controller
public class ResumeController extends BaseController {
	
	@Autowired
	private ResumeService resumeService;

	
	@PreAuthorize("hasRole('Administrator')")
	@RequestMapping(value = "/admin/resume/get", method = RequestMethod.GET)
	public String resumes(Model model, UserSearchCriteria criteria) {
		return "admin/resume/get";
	}
	
	@PreAuthorize("hasRole('Administrator')")
	@RequestMapping(value = "/admin/resume/load", method = RequestMethod.GET)
	public String loadResume(Model model) {
		try {
			JobKey jobKeyResumeLoad = new JobKey("jobResumeLoad", "group");
	    	JobDetail jobResumeLoad = JobBuilder.newJob(ResumeLoadJob.class)
			.withIdentity(jobKeyResumeLoad).build();
	    	
			Map <String, ResumeService> hm = new HashMap<String, ResumeService>();
			hm.put("resumeService", resumeService);
			
	    	JobDataMap jobDataMap = new  JobDataMap(hm);
	    	Trigger trigger1 = TriggerBuilder
	    			.newTrigger()
	    			.withIdentity("dummyTrigger", "group")
	    			.usingJobData(jobDataMap)
	    			.startNow()
	    			.build();
	    	Scheduler scheduler;
			scheduler = new StdSchedulerFactory().getScheduler();
	    	scheduler.start();
	    	scheduler.scheduleJob(jobResumeLoad, trigger1);
		} catch (SchedulerException e) {

		}
		return "admin/resume/get";
	}

}
