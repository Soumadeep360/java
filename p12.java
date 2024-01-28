//session.html
<html>
<head><title>Session login</title></head>
<form action="http://localhost:8080/login/session1.jsp" method="get">
Enter Name:<input type="text" name="uname">
<input type="submit" value="login" name="register">
</form>
</html>

//session1.jsp
<%@page language ="java" import ="java.util.*" errorPage=""%>
<form action="http://localhost:8080/login/session2.jsp" method="get">
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

//session2.jsp
<%@page language="java" import="java.util.*" errorPage="" %>
<% 
	Date d2=new Date();
	String un=(String)session.getAttribute("user");
	Long t1=(Long)session.getAttribute("time");
	Long t2=d2.getTime();
%>
Thank you!! <%=un %>
<br><br>
Session duration: <%=(t2-t1)/(60*60)%> seconds
<% session.invalidate(); %>
