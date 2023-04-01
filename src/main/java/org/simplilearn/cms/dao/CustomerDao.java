package org.simplilearn.cms.dao;

import java.util.List;

import org.simplilearn.cms.entities.Customer;



public interface CustomerDao {
          void insert(Customer customer);
          void delet(int cid);
          void update(int cid,Customer customer);
          List<Customer>getAll();
          Customer get(int cid);
}
