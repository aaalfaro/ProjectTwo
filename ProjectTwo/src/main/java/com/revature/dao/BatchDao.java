package com.revature.dao;

import java.util.List;

import com.revature.model.Batch;
import com.revature.model.Trainee;

public interface BatchDao {
	Batch getBatch(int id);
	boolean addBatch(Batch batch);
}
