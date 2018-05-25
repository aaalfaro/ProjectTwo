package com.revature.dao;

import java.util.List;

import com.revature.model.Trainer;

public interface TrainerDao {
	Trainer getTrainer(int id);
	List<Trainer> getAllTrainers();
	boolean insertTrainer(Trainer trainer);
}
