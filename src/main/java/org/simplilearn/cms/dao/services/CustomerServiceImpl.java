package org.simplilearn.cms.dao.services;

import java.util.List;

import org.simplilearn.cms.dao.CustomerDao;
import org.simplilearn.cms.dao.CustomerDaoImpl;
import org.simplilearn.cms.entities.Customer;

public class CustomerServiceImpl implements CustomerService{
    private CustomerDao dao=new CustomerDaoImpl();
	@Override
	public void insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		dao.insert(customer);
	}

	@Override
	public void deletCustomer(int cid) {
		// TODO Auto-generated method stub
		dao.delet(cid);
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public Customer getCustomer(int cid) {
		// TODO Auto-generated method stub
		return dao.get(cid);
	}

	@Override
	public void updateCustomer(int cid, Customer customer) {
		// TODO Auto-generated method stub
		dao.update(cid, customer);
	}

}
