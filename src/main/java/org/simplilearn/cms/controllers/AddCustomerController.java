package org.simplilearn.cms.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.cms.dao.services.CustomerService;
import org.simplilearn.cms.dao.services.CustomerServiceImpl;
import org.simplilearn.cms.entities.Customer;

@WebServlet("/process")
public class AddCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerService service=new CustomerServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int cid=Integer.parseInt(request.getParameter("cid"));
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		Customer customer=new Customer();
		customer.setCid(cid);
		customer.setName(name);
		customer.setLoc(address);
		service.insertCustomer(customer);
		response.sendRedirect("./display");
 }
}