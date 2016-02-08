<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="controller.User"%>
    <%@ page import="controller.MainServlet"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div> Name: <% String str = (String)request.getAttribute("name");
			 out.println(str);
			 %></div>
<div> Question: <% String str1=(String)request.getAttribute("question");
		out.println(str1);%> </div>

<input id="check1" type="checkbox" checked>

</body>
</html>