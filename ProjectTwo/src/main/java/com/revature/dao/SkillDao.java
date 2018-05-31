package com.revature.dao;

import java.util.List;

import com.revature.model.SkillType;

public interface SkillDao {
	boolean addSkill(SkillType type);
	List<SkillType> getTypes();
	
	List<SkillType> getTypesAjax();
}
