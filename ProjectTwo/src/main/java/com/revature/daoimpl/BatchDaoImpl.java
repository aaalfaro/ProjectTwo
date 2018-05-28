package com.revature.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.BatchDao;
import com.revature.model.Batch;
import com.revature.utility.HibernateUtility;

public class BatchDaoImpl implements BatchDao{
	
	private static BatchDaoImpl instance;
	private BatchDaoImpl() {}
	
	public static BatchDaoImpl getInstance() {
		if(instance ==null )
			instance = new BatchDaoImpl();
		return instance;
	}

	@Override
	public List<Batch> getBatch() {
		Session session = null;
		List<Batch> batch;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			batch = session.createQuery("from com.revature.model.Batch",Batch.class).getResultList();
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
	public boolean addBatch(Batch batch) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			t = session.beginTransaction();
			session.save(batch);
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
