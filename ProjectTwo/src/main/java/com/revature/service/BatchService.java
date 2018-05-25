package com.revature.service;

import com.revature.dao.BatchDao;
import com.revature.daoimpl.BatchDaoImpl;
import com.revature.model.Batch;

public class BatchService {
	private static BatchDao dao = BatchDaoImpl.getInstance();
	
	public BatchService() {}
	
	public static Batch Batch(int id) {
		return dao.getBatch(id);
	}
	
	public static boolean addBatch(Batch batch) {
		return dao.addBatch(batch);
	}

}
