package com.revature.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

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

	@Override
	public List<Trainer> getTrainerNames() {
		List<Trainer> trainers;
		Session session = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			CriteriaBuilder build = session.getCriteriaBuilder();
			CriteriaQuery<Trainer> criteria = build.createQuery(Trainer.class);
			Root<Trainer>trainer = criteria.from(Trainer.class);

			criteria.multiselect(trainer.get("id"),trainer.get("name"));
			trainers = session.createQuery(criteria).getResultList();
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
