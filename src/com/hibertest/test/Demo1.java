package com.hibertest.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibertest.domain.Customer;
import com.hibertest.domain.Linkman;
import com.hibertest.uitls.HibernateUtils;

public class Demo1 {

	/**
	 * ����ɾ��
	 * customer.xml /linkman.xml���޸� cascade="save-update,delete"
	 * ������ͻ�1��ɾ������ϵ��1,2 ����ɾ��
	 */
	@Test
	public void Run6(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Linkman l = session.get(Linkman.class, 1L);
		session.delete(l);
		
		
		tr.commit();
	}
	/**
	 * ����ɾ��
	 * ɾ��linkman,����xml,--->ɾ��customer,��ϵ��2��l2�����lkm_cust_id��Ϊ��
	 */
	@Test
	public void Run5(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Linkman l = session.get(Linkman.class, 1L);
		session.delete(l);
		
		
		tr.commit();
	}
	
	/**
	 * ����ɾ��
	 * ɾ��customer ���޸�xml�ļ�-->��ϵ���Զ���ɾ��
	 */
	@Test
	public void Run4(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Customer c = session.get(Customer.class, 1L);
		session.delete(c);
		
		tr.commit();
	}
	/**
	 * �����������������
	 * ����Linkman--�޸�Linkman.hbm.xml
	 */
	@Test
	public void Run3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Customer c = new Customer();
		c.setCust_name("�ͻ�");
		
		Linkman l1 = new Linkman();
		Linkman l2 = new Linkman();
		l1.setLkm_name("��ϵ��1");
		l2.setLkm_name("��ϵ��2");
		 
		
		l1.setCustomer(c);
		l2.setCustomer(c);
		
		session.save(l1);
		session.save(l2);
		
		tr.commit();
	}
	/**
	 * �����������������
	 * ����ͻ�-��Ҫ�޸�Customer.hbm.xml
	 */
	@Test
	public void Run2(){
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
		
		
		session.save(c);
		
		tr.commit();
	}
	/**
	 * ˫�����
	 */
	@Test
	public void Run1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Customer c = new Customer();
		c.setCust_name("kehu");
		
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
