package com.revature.service;

import java.util.List;

import com.revature.dao.AssessmentDao;
import com.revature.daoimpl.AssessmentDaoImpl;
import com.revature.model.Assessment;

public class AssessmentService {
	
	private static AssessmentDao dao = AssessmentDaoImpl.getInstance();
	private AssessmentService() {}
	
	public static List<String> getCategories(){
		return dao.getCategories();
	}
	
	public static List<String> getTypes(){
		return dao.getType();
	}
	
	public static boolean addAssessment(Assessment a) {
		return dao.insertAssessment(a);
	}
	
	public static Assessment getAssessment(int id) {
		return dao.getAssessment(id);
	}

}
