package com.revature.service;

import java.util.List;

import com.revature.dao.TrainerDao;
import com.revature.daoimpl.TrainerDaoImpl;
import com.revature.model.Trainer;

public class TrainerService {

	private static TrainerDao dao = TrainerDaoImpl.getInstance();
	private TrainerService() {}
	
	public static Trainer getTrainer(int id) {
		return dao.getTrainer(id);
	}
	
	public static List<Trainer> getAllTrainers(){
		return dao.getAllTrainers();
	}
	
	public static boolean insertNewTrainer(Trainer trainer) {
		return dao.insertTrainer(trainer);
	}
	
	//For AJAX
	public static List<Trainer> AllTrainers(){
		return dao.getTrainerNames();
	}
	
	
}
