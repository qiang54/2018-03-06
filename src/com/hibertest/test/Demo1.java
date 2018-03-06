package com.hibertest.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibertest.domain.Customer;
import com.hibertest.domain.Linkman;
import com.hibertest.uitls.HibernateUtils;

public class Demo1 {

	/**
	 * 级联删除
	 * customer.xml /linkman.xml都修改 cascade="save-update,delete"
	 * 结果：客户1被删除，联系人1,2 都被删除
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
	 * 级联删除
	 * 删除linkman,配置xml,--->删除customer,联系人2，l2的外键lkm_cust_id置为空
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
	 * 级联删除
	 * 删除customer ，修改xml文件-->联系人自动被删除
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
	 * 单向关联，级联保存
	 * 保存Linkman--修改Linkman.hbm.xml
	 */
	@Test
	public void Run3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Customer c = new Customer();
		c.setCust_name("客户");
		
		Linkman l1 = new Linkman();
		Linkman l2 = new Linkman();
		l1.setLkm_name("联系人1");
		l2.setLkm_name("联系人2");
		 
		
		l1.setCustomer(c);
		l2.setCustomer(c);
		
		session.save(l1);
		session.save(l2);
		
		tr.commit();
	}
	/**
	 * 单向关联，级联保存
	 * 保存客户-需要修改Customer.hbm.xml
	 */
	@Test
	public void Run2(){
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
		
		
		session.save(c);
		
		tr.commit();
	}
	/**
	 * 双向关联
	 */
	@Test
	public void Run1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Customer c = new Customer();
		c.setCust_name("kehu");
		
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
