package com.kushagra.hibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	/* TO CHECK IF ANY SESSION IS ACTIVE */
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

	/* CREATING A SINGLETON SESSION FACTORY OBJECT */
	private static SessionFactory factory = null;
	static {
		factory = new Configuration().configure("com/kushagra/configuration/hibernate.cfg.xml").buildSessionFactory();

	}

	/* FOR OPENING ACTIVE SESSION */
	public static Session getSession() {

		Session session = null;
		if (threadLocal.get() == null) {
			session = factory.openSession();
			threadLocal.set(session);
		} else {
			session = threadLocal.get();
		}
		return session;

	}
	
	/*FOR TRANSACTION OPENING*/
	public static Transaction getTransaction(Session session) {
		Transaction tr = session.beginTransaction();
		return tr;
	}
	
	/* FOR CRITERIA CLASS */
	public static Criteria getCriteria() {
		Criteria cri=null;
		return cri;
	}

	/* CLOSING ACTIVE SESSION */
	public static void closeSession() {
		Session session = null;
		if (threadLocal.get() != null) {
			session = threadLocal.get();
			session.close();
			threadLocal.remove();
		}
	}

	/* CLOSING SESSION FACTORY */
	public static void closeSessionFactory() {
		factory.close();
	}

}
