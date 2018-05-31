package com.revature.dao;

import java.util.List;

import com.revature.model.Assessment;

public interface AssessmentDao {
	List<String> getCategories();
	List<String> getType();
	boolean insertAssessment(Assessment a);
	Assessment getAssessment(int id);
}
