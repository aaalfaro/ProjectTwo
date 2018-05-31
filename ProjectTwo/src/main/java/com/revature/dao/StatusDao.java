package com.revature.dao;

import java.util.List;

import com.revature.model.Status;

public interface StatusDao {
	boolean addStatus(Status status);
	List<Status> getEverything();
	
	List<Status> getEverythingAjax();
}
