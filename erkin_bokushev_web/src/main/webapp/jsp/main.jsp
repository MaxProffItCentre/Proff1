<%@page import="support.MainServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/styles.css" rel="stylesheet" type="text/css">
<title>Main page</title>
</head>
<body>
	<table>
		<tr>
			<td style="padding: 50px">
			<h3>Миссия проекта</h3>
			<p>"Данная служба поддержки создана для того, чтобы дать ответ на вопрос, <br>
			поставленный любым пользователем нашего сервиса. <br>
			На каждый вопрос найдется необходимый ответчик и выдаст ответ. <br> 
			В случае жалобы, вопросом непосредственно занимается директор нашего сервиса. <br>
			Просьба задавать конкретные вопросы, и будут получены конкретные ответы."</p>
			</td>
			<td>
				<table >
					<tr> 
					<%
					String text = "";
					if (request.getAttribute("text")== null) {
						text = "";
					} else {
						text = (String)request.getAttribute("text");
					}
					
					%>
					<td style="padding-left: 200px">
						<h4>Войти в систему</h4>
						<form action="http://localhost:8080/erkin_bokushev_web/main" method="get">
						<p>Логин<br>
						<input type = "text" name = "login"><br>
						Пароль<br>
						<input type = "password" name = "pass"><br></p> 
						<input type = "submit" value="Войти"> 
						</form>
						<p><% out.println(text); %></p>
					</td>
					</tr>
				</table>
			
			</td>
		</tr>
		
		<tr>
			<td></td>
			<td style="padding-left: 200px">
			<h4>-----Статистика------</h4>
			<p>Количество людей, задавших вопрос - <% int countQuestion = 0; out.println(countQuestion);%> </p>
			<p>Количество выданных ответов - <% int countAnswer = 0; out.println(countAnswer); %> </p>
			</td>
		</tr>
	
	</table>


</body>
</html>