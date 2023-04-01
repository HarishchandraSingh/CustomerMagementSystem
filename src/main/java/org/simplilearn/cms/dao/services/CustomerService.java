package org.simplilearn.cms.dao.services;

import java.util.List;

import org.simplilearn.cms.entities.Customer;

public interface CustomerService {
      void insertCustomer(Customer customer);
      void deletCustomer(int cid);
      List<Customer> getCustomers();
      Customer getCustomer(int cid);
      void updateCustomer(int cid,Customer customer);
}
