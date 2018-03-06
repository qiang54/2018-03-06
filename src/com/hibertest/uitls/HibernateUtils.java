package com.hibertest.uitls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate π§æﬂ¿‡
 * @author dell
 *
 */
public class HibernateUtils {

	private static final Configuration CONFIG;
	private static final SessionFactory FACTORY;
	
	static {
		CONFIG = new Configuration().configure();
		FACTORY = CONFIG.buildSessionFactory();
	}
	
	public static Session getSession(){
		
		return FACTORY.openSession();
	}
	
	public static  Session getCurrentSession(){
		
		return FACTORY.getCurrentSession();
	}
}
