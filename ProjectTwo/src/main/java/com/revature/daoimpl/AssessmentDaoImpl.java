package com.revature.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.AssessmentDao;
import com.revature.model.Assessment;
import com.revature.utility.HibernateUtility;

public class AssessmentDaoImpl implements AssessmentDao{
	private static AssessmentDaoImpl instance;
	private AssessmentDaoImpl() {}
	
	public static AssessmentDaoImpl getInstance() {
		if(instance == null) {
			instance = new AssessmentDaoImpl();
		}return instance;
	}

	@Override
	public List<String> getCategories() {
		Session session = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			Query q = session.createQuery("SELECT category from Assessment");
			List<String> category = q.getResultList();
			return category;
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
	public List<String> getType() {
		Session session = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			Query q = session.createQuery("SELECT type from assessment");
			List<String> type = q.getResultList();
			return type;
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
	public boolean insertAssessment(Assessment a) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			t = session.beginTransaction();
			session.save(a);
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
