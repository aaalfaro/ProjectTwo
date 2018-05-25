package com.revature.daoimpl;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.TrainerDao;
import com.revature.model.Trainer;
import com.revature.utility.HibernateUtility;

public class TrainerDaoImpl implements TrainerDao{
	
	private static TrainerDaoImpl instance;
	private TrainerDaoImpl() {}
	
	public static TrainerDaoImpl getInstance() {
		if(instance ==null )
			instance = new TrainerDaoImpl();
		return instance;
	}

	@Override
	public Trainer getTrainer(int id) {
		Session session = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			Trainer trainer = session.createQuery("from Trainer t where t.id like :trainerId",Trainer.class).setParameter("trainerId", id).getSingleResult();
			return trainer;
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
	public boolean insertTrainer(Trainer trainer) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			t = session.beginTransaction();
			session.save(trainer);
			t.commit();
			System.out.println();
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
	public List<Trainer> getAllTrainers() {
		List<Trainer> trainers;
		Session session = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			trainers = session.createQuery("from com.revature.model.Trainer", Trainer.class).getResultList();
			return trainers;
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
