package com.revature.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.TraineeDao;
import com.revature.model.Trainee;
import com.revature.service.BatchService;
import com.revature.utility.HibernateUtility;

public class TraineeDaoImpl implements TraineeDao {

	private static TraineeDaoImpl instance;

	private TraineeDaoImpl() {
	}

	public static TraineeDaoImpl getInstance() {
		if (instance == null)
			instance = new TraineeDaoImpl();
		return instance;
	}

	@Override
	public Trainee getTrainee(int id) {
		Session session = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			Trainee trainee = session.createQuery("from Trainee t where t.id like :id", Trainee.class)
					.setParameter("id", id).getSingleResult();
			return trainee;
		} catch (HibernateException hbe) {
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
		} catch (HibernateException hbe) {
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
		} catch (HibernateException hbe) {
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
	public List<Trainee> AjaxTrainee() {
		Session session = null;
		List<Trainee> trainees;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			CriteriaBuilder build = session.getCriteriaBuilder();
			CriteriaQuery<Trainee> criteria = build.createQuery(Trainee.class);
			Root<Trainee> trainee = criteria.from(Trainee.class);

			criteria.multiselect(trainee.get("name"), trainee.get("email"), trainee.get("skype"), trainee.get("phone"),
					trainee.get("college"), trainee.get("degree"), trainee.get("major"), trainee.get("recruiter"),
					trainee.get("screener"), trainee.get("completion"), trainee.get("url"));
			trainees = session.createQuery(criteria).getResultList();
			return trainees;
		} catch (HibernateException hbe) {
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
	public boolean assignBatch(int traineeId, int batchId) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			t = session.beginTransaction();
			Trainee train = this.getTrainee(traineeId);
			train.setBatch(BatchService.getBatch(batchId));
			session.saveOrUpdate(train);
			t.commit();
			return true;
		} catch (HibernateException hbe) {
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
	public boolean removeFromBatch(int traineeId) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			t = session.beginTransaction();
			Trainee train = this.getTrainee(traineeId);
			train.setBatch(null);
			session.saveOrUpdate(train);
			t.commit();
			return true;
		} catch (HibernateException hbe) {
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
