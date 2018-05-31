package com.revature.service;

import java.util.List;

import com.revature.dao.TraineeDao;
import com.revature.daoimpl.TraineeDaoImpl;
import com.revature.model.Trainee;

public class TraineeService {
	private static TraineeDao dao = TraineeDaoImpl.getInstance();
	private TraineeService() {}
	
	
	public static Trainee getTrainee(int id) {
		return dao.getTrainee(id);
	}
	
	public static boolean insertTrainee(Trainee trainee) {
		return dao.addTrainee(trainee);
	}
	
	public static List<Trainee> getAllTrainee(){
		return dao.getAllTrainees();
	}
	
	public static List<Trainee> AjaxTrainee(){
		return dao.AjaxTrainee();
	}
}
