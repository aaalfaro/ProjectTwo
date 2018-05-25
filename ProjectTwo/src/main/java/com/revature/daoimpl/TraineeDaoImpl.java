package com.revature.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.TraineeDao;
import com.revature.model.Trainee;
import com.revature.utility.HibernateUtility;

public class TraineeDaoImpl implements TraineeDao {
	
	private static TraineeDaoImpl instance;
	private TraineeDaoImpl() {}
	
	public static TraineeDaoImpl getInstance() {
		if(instance ==null )
			instance = new TraineeDaoImpl();
		return instance;
	}


	@Override
	public Trainee getTrainee(int id) {
		Session session = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			Trainee trainee = session.createQuery("from Trainee t where t.id like : id",Trainee.class).setParameter("id", id).getSingleResult();
			return trainee;
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
	public List<Trainee> getAllTrainees() {
		List<Trainee> batch;
		Session session = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			batch = session.createQuery("from com.revature.model.Trainee", Trainee.class).getResultList();
			return batch;
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
	public boolean addTrainee(Trainee trainee) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			t = session.beginTransaction();
			session.save(trainee);
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
