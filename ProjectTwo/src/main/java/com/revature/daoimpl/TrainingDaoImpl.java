package com.revature.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.TrainingTypeDao;
import com.revature.model.TrainingType;
import com.revature.utility.HibernateUtility;

public class TrainingDaoImpl implements TrainingTypeDao{
	
	private static TrainingDaoImpl instance;
	
	private TrainingDaoImpl() {}
	
	public static TrainingDaoImpl getInstance() {
		if(instance == null)
			instance = new TrainingDaoImpl();
		return instance;
	}

	@Override
	public List<TrainingType> getTypes() {
		Session session = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			List<TrainingType> types = session.createQuery("from com.revature.model.TrainingType",TrainingType.class).getResultList();
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
	public boolean addType(TrainingType type) {
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
}
