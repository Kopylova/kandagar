package com.kandagar.rls.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.kandagar.rls.extension.AppConstants;
import com.kandagar.rls.model.ResumeModel;
import com.kandagar.rls.service.ResumeService;
 
public class ResumeLoadJob extends QuartzJobBean {

	ResumeService resumeService;
	
	@Autowired
    public void setResumeService(ResumeService resumeService) {
        this.resumeService = resumeService;
    }
	
    @Async
	@Override
	protected void executeInternal(JobExecutionContext context)
		throws JobExecutionException {
    	Integer offset = AppConstants.OFFSET;
		Integer limit = AppConstants.LIMIT;
		while(true){
			String url = "http://rabota.e1.ru/api/v1/resumes/?limit=" + limit +"&offset=" + offset + "&search_key=1z7sn9e&q=&average_salary=true";
			List<ResumeModel> resumes = resumeService.loadResume(url);
			if(resumes.size() == 0){
				break;
			}
			for (ResumeModel resume : resumes) {
				resumeService.save(resume);
			}
            offset = offset + 100;
		}
	}
 
}