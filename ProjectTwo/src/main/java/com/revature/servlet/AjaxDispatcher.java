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
				return TrainerService.getAllTrainers();
			case "/ProjectTwo/getTrainee.ajax":
				return TraineeService.getAllTrainee();
			case "/ProjectTwo/getBatch.ajax":
				return BatchService.Batch();
			case "/ProjectTwo/getSkill.ajax":
				return SkillTypeService.getTypes();
			case "/ProjectTwo/getTrainingType.ajax":
				return TrainingTypeService.getAllTypes();
			case "/ProjectTwo/getStatus.ajax":
				return StatusService.getEverything();
			case "/ProjectTwo/getAssessmentCategory.ajax":
				return AssessmentService.getCategories();
			case "/ProjectTwo/getAssessmentTypes.ajax":
				return AssessmentService.getTypes();
		}return null;
		
	}
}


