package com.revature.service;

import java.util.List;

import com.revature.dao.SkillDao;
import com.revature.daoimpl.SkillDaoImpl;
import com.revature.model.SkillType;

public class SkillTypeService {
	
	private static SkillDao dao = SkillDaoImpl.getInstance();
	
	private SkillTypeService() {}
	
	public static List<SkillType> getTypes(){
		return dao.getTypes();
	}
	
	public static boolean addSkill(SkillType type) {
		return dao.addSkill(type);
	}

}
