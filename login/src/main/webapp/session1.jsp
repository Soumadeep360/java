<%@page language ="java" import ="java.util.*" errorPage=""%>
<form method="get" action="http://localhost:8080/login/session2.jsp">
	<% Date d=new Date(); %>
	<p align="right"> Time: <%= d.getTime()%></p>
	<% 
	String un=request.getParameter("uname");
	session.setAttribute("user",un);
	session.setAttribute("time",d.getTime());
	%>
	Hello <%=un %>
	<br><br>
	<input type="submit" value="logout">
</form>