<%@page import="org.simplilearn.cms.entities.Customer"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <a href="addCustomer.jsp">Add Customer</a>
     <a href="./display">List Customer</a>
    <%
      if(request.getAttribute("customers")!=null)
      {
    List<Customer> customers=(List<Customer>)request.getAttribute("customers");
    %>
    <table border="1">
    <tr>
         <th>Cid</th>
         <th>Cname</th>
         <th>Address</th>
    </tr>
    <%
      for(Customer customer:customers)
      {
    %>
        <tr>
          <td><%=customer.getCid()%></td>
          <td><%=customer.getName()%></td>
          <td><%=customer.getLoc()%></td>
          <td> <a href="./delete?cid=<%=customer.getCid()%>">Delete</a></td>
          </tr>
    <%
       }
      }
    %>   
    </table>
</body>
</html>
