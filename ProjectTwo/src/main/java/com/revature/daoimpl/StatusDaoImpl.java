package com.revature.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.StatusDao;
import com.revature.model.Status;
import com.revature.utility.HibernateUtility;

public class StatusDaoImpl implements StatusDao {
	private static StatusDaoImpl instance;
	
	public static StatusDaoImpl getInstance() {
		if(instance == null) {
			instance = new StatusDaoImpl();
		}return instance;
	}
	private StatusDaoImpl() {}

	@Override
	public boolean addStatus(Status status) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			t = session.beginTransaction();
			session.save(status);
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
	public List<Status> getEverything() {
		Session session = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			List<Status> status = session.createQuery("from com.revature.model.Status", Status.class).getResultList();
			return status;
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
	public List<Status> getEverythingAjax() {
		Session session = null;
		List<Status> types;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			CriteriaBuilder build = session.getCriteriaBuilder();
			CriteriaQuery<Status> criteria = build.createQuery(Status.class);
			Root<Status> status = criteria.from(Status.class);
			criteria.multiselect(status.get("status"));
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
