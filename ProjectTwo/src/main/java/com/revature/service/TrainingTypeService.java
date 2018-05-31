package com.revature.service;

import java.util.List;

import com.revature.dao.TrainingTypeDao;
import com.revature.daoimpl.TrainingDaoImpl;
import com.revature.model.TrainingType;

public class TrainingTypeService {
	private static TrainingTypeDao dao = TrainingDaoImpl.getInstance();
	
	private TrainingTypeService() {}
	
	public static boolean addType(TrainingType type) {
		return dao.addType(type);
	}
	
	public static List<TrainingType> getAllTypes(){
		return dao.getTypes();
	}
	
	public static List<TrainingType> AjaxType(){
		return dao.getTypesAjax();
	}
}