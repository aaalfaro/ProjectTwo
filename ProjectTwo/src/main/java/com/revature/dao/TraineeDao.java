package com.revature.dao;

import java.util.List;

import com.revature.model.Trainee;

public interface TraineeDao {
	Trainee getTrainee(int id);
	List<Trainee> getAllTrainees();
	boolean addTrainee(Trainee trainee);
	List<Trainee> AjaxTrainee();
	public boolean assignBatch(int traineeId, int batchId);
	public boolean removeFromBatch(int traineeId);
}
