<%@page import="java.util.ArrayList"%>
<%@page import="data.User"%>
<%@page import="support.UsersServlet"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<title>Messages</title>
</head>
<body>
	<table>
		<tr>
			<td>
			<h3>Сообщение</h3>
			<form action="http://localhost:8080/erkin_bokushev_web/messages" method="get"">
			<textarea rows="10" cols="50" name = "textmessage"></textarea>
			<select size="4" multiple="multiple" name = "typemessage">
			<option disabled="disabled">Выберите тип сообщения</option>
			<option value = "complaint">Жалоба</option>
			<option selected="selected" value = "question">Вопрос</option>
			<option value = "organization question">Организационный вопрос</option>
			<option value = "complaint and question">Жалоба и вопрос</option>
			<option value = "complaint and organization question">Жалоба и организационный вопрос</option>
			</select><br>
			<input type = "submit" value = "Send"> 
			</form>
			</td>
		</tr>
	</table>
</body>
</html>
