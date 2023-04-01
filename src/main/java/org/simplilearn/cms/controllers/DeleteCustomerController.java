package org.simplilearn.cms.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.cms.dao.services.CustomerService;
import org.simplilearn.cms.dao.services.CustomerServiceImpl;

@WebServlet("/delete")
public class DeleteCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerService service=new CustomerServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int cid=Integer.parseInt(request.getParameter("cid"));
		service.deletCustomer(cid);
		RequestDispatcher rd=request.getRequestDispatcher("/display");
		rd.forward(request, response);
	}

}
