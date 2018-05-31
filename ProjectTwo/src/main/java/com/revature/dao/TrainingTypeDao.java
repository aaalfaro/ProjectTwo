package com.revature.dao;

import java.util.List;

import com.revature.model.TrainingType;

public interface TrainingTypeDao {
	List<TrainingType> getTypes();
	boolean addType(TrainingType type);
	
	List<TrainingType> getTypesAjax();
}
