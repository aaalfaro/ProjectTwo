package com.revature.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.SkillDao;
import com.revature.model.SkillType;
import com.revature.utility.HibernateUtility;

public class SkillDaoImpl implements SkillDao {
	
	private static SkillDaoImpl instance;
	
	private SkillDaoImpl() {}
	
	public static SkillDaoImpl getInstance() {
		if(instance == null)
			instance = new SkillDaoImpl();
		return instance;
	}

	@Override
	public boolean addSkill(SkillType type) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			t = session.beginTransaction();
			session.save(type);
			t.commit();
			return true;
		}catch (HibernateException hbe) {
			hbe.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session successfully closed: " + !session.isOpen());
			}
		}
		return false;
	}

	@Override
	public List<SkillType> getTypes() {
		Session session = null;
		List<SkillType> types;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			types = session.createQuery("from com.revature.model.SkillType",SkillType.class).getResultList();
			return types;
		}catch (HibernateException hbe) {
			hbe.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session successfully closed: " + !session.isOpen());
			}
		}
		return null;
	}

	@Override
	public List<SkillType> getTypesAjax() {
		Session session = null;
		List<SkillType> types;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			CriteriaBuilder build = session.getCriteriaBuilder();
			CriteriaQuery<SkillType> criteria = build.createQuery(SkillType.class);
			Root<SkillType> skill = criteria.from(SkillType.class);
			criteria.multiselect(skill.get("type"));
			types = session.createQuery(criteria).getResultList();
			return types;
		}catch (HibernateException hbe) {
			hbe.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session successfully closed: " + !session.isOpen());
			}
		}
		return null;
	}

}
