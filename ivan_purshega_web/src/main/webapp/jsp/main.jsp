<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	Main page<br>
	<tr>  </tr>
<div><% out.println((String)request.getAttribute("var1").toString()); %></div>

 <form action="main" method="get">
  <input type="text" name="field1"/>
  <input type="text" name="field2"/>
  <input type="submit" value="send" />
 </form>
 <div><% if(request.getAttribute("var2")!=null)out.println((String)request.getAttribute("var2").toString()); %></div>
</body>
</html>