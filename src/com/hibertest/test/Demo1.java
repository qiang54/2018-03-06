package com.hibertest.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibertest.domain.Customer;
import com.hibertest.domain.Linkman;
import com.hibertest.uitls.HibernateUtils;

public class Demo1 {

	/**
	 * ˫�����
	 */
	@Test
	public void Run1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Customer c = new Customer();
		c.setCust_name("�ͻ�");
		
		Linkman l1 = new Linkman();
		Linkman l2 = new Linkman();
		l1.setLkm_name("��ϵ��1");
		l2.setLkm_name("��ϵ��2");
		 
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
