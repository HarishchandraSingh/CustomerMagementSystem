package org.simplilearn.cms.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.cms.dao.services.CustomerService;
import org.simplilearn.cms.dao.services.CustomerServiceImpl;
import org.simplilearn.cms.entities.Customer;



@WebServlet("/display")
public class DisplayControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;

    //CustomerDao customerdao=new CustomerDaoImpl();
	private CustomerService service=new CustomerServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("text/html");
	 PrintWriter out=response.getWriter();
	 List<Customer> customers=service.getCustomers();
	// for(Customer customer:customers)
	//	 System.out.println(customer.getCid()+"\t"+customer.getName()+"\t"+customer.getLoc());
	 request.setAttribute("customers", customers);
	 RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	 rd.forward(request, response);
	 /*
		 * List<Customer> customers=customerdao.getAll();
		 * out.println("<table border='1'>"); out.println("<tr>");
		 * out.println("<th>Cid</th>"); out.println("<th>Name</th>");
		 * out.println("<th>Location</th>"); out.println("</tr>"); for(Customer
		 * customer:customers) { out.println("<tr>");
		 * out.println("<td>"+customer.getCid()+"</td><td>"+customer.getName()+
		 * "</td><td>"+customer.getLoc()+"</td>"); out.println("</tr>"); }
		 * out.println("</table>");
		 */
	 out.close();
	}

}
