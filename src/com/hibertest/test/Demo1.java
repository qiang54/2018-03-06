package com.hibertest.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibertest.domain.Customer;
import com.hibertest.domain.Linkman;
import com.hibertest.uitls.HibernateUtils;

public class Demo1 {

	/**
	 * 双向关联
	 */
	@Test
	public void Run1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Customer c = new Customer();
		c.setCust_name("客户");
		
		Linkman l1 = new Linkman();
		Linkman l2 = new Linkman();
		l1.setLkm_name("联系人1");
		l2.setLkm_name("联系人2");
		 
		c.getLinkmans().add(l1);
		c.getLinkmans().add(l2);
		
		l1.setCustomer(c);
		l2.setCustomer(c);
		
		session.save(c);
		session.save(l1);
		session.save(l2);
		
		tr.commit();
	}
}
