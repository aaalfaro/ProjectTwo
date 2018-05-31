package com.revature.service;

import java.util.List;

import com.revature.dao.BatchDao;
import com.revature.daoimpl.BatchDaoImpl;
import com.revature.model.Batch;

public class BatchService {
	private static BatchDao dao = BatchDaoImpl.getInstance();
	
	public BatchService() {}
	
	public static List<Batch> getBatch() {
		return dao.getBatch();
	}
	
	public static boolean addBatch(Batch batch) {
		return dao.addBatch(batch);
	}
	
	//For AJAX
	public static List<Batch> allBatch(){
		return dao.getBatchForAjax();
	}

}
