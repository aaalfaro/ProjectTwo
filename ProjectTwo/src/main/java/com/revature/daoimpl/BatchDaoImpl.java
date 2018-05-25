package com.revature.daoimpl;

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
	public Batch getBatch(int id) {
		Session session = null;
		try {
			session = HibernateUtility.getSessionFactory().getCurrentSession();
			Batch batch = session.createQuery("from Batch b where b.id like :id",Batch.class).setParameter("id", id).getSingleResult();
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
