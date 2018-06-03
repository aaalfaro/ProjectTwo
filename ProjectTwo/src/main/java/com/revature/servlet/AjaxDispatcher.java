package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.AssessmentService;
import com.revature.service.BatchService;
import com.revature.service.SkillTypeService;
import com.revature.service.StatusService;
import com.revature.service.TraineeService;
import com.revature.service.TrainerService;
import com.revature.service.TrainingTypeService;



public class AjaxDispatcher {
	private AjaxDispatcher() {}
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
			case "/ProjectTwo/getTrainers.ajax":
				return TrainerService.AllTrainers();
			case "/ProjectTwo/getTrainee.ajax":
				return TraineeService.AjaxTrainee();
			case "/ProjectTwo/getBatch.ajax":
				return BatchService.allBatch();
			case "/ProjectTwo/getSkill.ajax":
				return SkillTypeService.AjaxTypes();
			case "/ProjectTwo/getTrainingType.ajax":
				return TrainingTypeService.AjaxType();
			case "/ProjectTwo/getStatus.ajax":
				return StatusService.AjaxStatus();
			case "/ProjectTwo/getAssessmentCategory.ajax":
				return AssessmentService.getCategories();
			case "/ProjectTwo/getAssessmentTypes.ajax":
				return AssessmentService.getTypes();
			case "/ProjectTwo/getAssessment.ajax":
				return AssessmentService.getAssessment(181);
		}return null;
		
	}
}


