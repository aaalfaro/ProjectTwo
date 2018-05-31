package com.revature.service;

import java.util.List;

import com.revature.dao.StatusDao;
import com.revature.daoimpl.StatusDaoImpl;
import com.revature.model.Status;

public class StatusService {
	private static StatusDao dao = StatusDaoImpl.getInstance();
	private StatusService() {}
	
	public static boolean addStatus(Status status) {
		return dao.addStatus(status);
	}
	
	public static List<Status> getEverything(){
		return dao.getEverything();
	}
	
	public static List<Status> AjaxStatus(){
		return dao.getEverythingAjax();
	}
}
