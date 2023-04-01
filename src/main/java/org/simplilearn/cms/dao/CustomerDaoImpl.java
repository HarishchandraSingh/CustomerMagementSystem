package org.simplilearn.cms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.cms.config.HibConfig;
import org.simplilearn.cms.entities.Customer;


public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void insert(Customer customer) {
		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(customer);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		session.close();
	}

	private Session getSession() {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		return session;
	}

	@Override
	public void delet(int cid) {
		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Customer customer = session.get(Customer.class, cid);
			session.delete(customer);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		session.close();
	}

	@Override
	public void update(int cid, Customer customer) {
		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Customer customer2 = session.get(Customer.class, cid);
			customer2.setName(customer.getName());
			customer2.setLoc(customer.getLoc());
			customer2.setDoj(customer.getDoj());
			session.save(customer2);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		session.close();
	}

	@Override
	public List<Customer> getAll() {
		Session session = getSession();
		Query<Customer> query = session.createQuery("select c from org.simplilearn.cms.entities.Customer c");
		List<Customer> customers = query.list();
		return customers;
	}

	@Override
	public Customer get(int cid) {
		Session session = getSession();
		return session.get(Customer.class, cid);
	}

}
