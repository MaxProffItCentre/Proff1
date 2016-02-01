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
<title>Order of users</title>
</head>
<body>
<table>
<tr>
<td>Users</td>
</tr>
<tr>
<table>
	<tr>
		<td width="100px">Имя</td>
		<td width="100px">Логин</td>
		<td width="100px">Пароль</td>
		<td>
			<table>
			<tr>
			<td style = "width: 100px">Роли</td>
			<td>Назначить роли</td>
			</tr>
			</table>
		</td>
	</tr>
	<% 
	String [] filtrChecked = (String[]) request.getAttribute("filtrChecked");
	ArrayList<User> users = new ArrayList <User>();
	boolean adminCheck= true;
	if (filtrChecked != null) {
	for (int i = 0; i<filtrChecked.length; i++) {
		if (filtrChecked[i].equals("1") && i == 0){ users = (ArrayList<User>)request.getAttribute("usersAnswers");adminCheck=false; break;}
		else if (filtrChecked[i].equals("1") && i == 1) {users = (ArrayList<User>)request.getAttribute("usersManages");adminCheck=false; break;}
		else if (filtrChecked[i].equals("1") && i == 2) {users = (ArrayList<User>)request.getAttribute("usersDirectors");adminCheck=false; break;}
		else if (filtrChecked[i].equals("1") && i == 3) {users = (ArrayList<User>)request.getAttribute("usersAdmins");adminCheck=false; break;}
		else if (filtrChecked[i].equals("1") && i == 4) {users = (ArrayList<User>)request.getAttribute("users"); break;}
		else {users = (ArrayList<User>)request.getAttribute("users");}
	}
	}
	
	String var = "";
	for (int i = 0; i<users.size(); i++ ){
		var += "<tr>";
		var += users.get(i).toTableUsers();
		var +="<td> \n";
		var += "<table> \n";
		var +="<tr> \n";
		if (adminCheck) {
			var += "<td style = \"width: 100px\">";
			if (users.get(i).isCanAnswer()) var += "<p>Answer ";
			if (users.get(i).isCanManage()) var += "Manage ";
			if (users.get(i).isDirector()) var += "Director ";
			if (users.get(i).isAdmin()) var += "Admin</p>";
			var += "</td>";
			var +="<td>";
			var +="<form action=\"http://localhost:8080/erkin_bokushev_web/users\" method=\"get\">";	
			var +="<p style=\"display:inline\"><input type = \"checkbox\" name =\"Answer" + i + "\" value = \"isCanAnswer\"/>Answer \n";
			var +="<input type = \"checkbox\" name = \"Manage" + i + "\" value = \"isCanManage\"/>Manage \n";
			var +="<input type = \"checkbox\" name = \"Director" + i + "\" value = \"isCanDirector\"/>Director \n"; 
			var +="<input type = \"checkbox\" name = \"Admin" + i + "\" value = \"isCanAdmin\"/>Admin</p> \n";
			var +="<input type = \"checkbox\" name = \"ResetAll" + i + "\" value = \"ResetAll\"/>Reset All</p> \n";
			if (i == users.size()-1) {
				var +="<td>";
				var +="<p><input type = \"submit\" value = \"Accept\"></p> \n"; 
				var +="</form>";	
				var +="</td>";
			}
		
		var +="</td>";
		} else {
			var +="<td>";
			if (filtrChecked[0].equals("1")) var += "<p> Answer </p>";
			if (filtrChecked[1].equals("1")) var += "<p> Manage </p>";
			if (filtrChecked[2].equals("1")) var += "<p> Director </p>";
			if (filtrChecked[3].equals("1")) var += "<p> Admin </p>";
			var +="</td>";
		}
		var +="</tr> \n";
		var += "</table> \n";
		var += "</tr>";
	}
	out.println(var);
	%>

</tr>
</table>
</tr>
<tr>
	<td>Фильтр</td>
</tr>
<tr>
	<td>
	<form action="http://localhost:8080/erkin_bokushev_web/users" method="get">
	<input type = "radio" name = "roles" value = "Answers" />Answers
	<input type = "radio" name = "roles" value = "Manages" />Manages
	<input type = "radio" name = "roles" value = "Directors"/>Directors
	<input type = "radio" name = "roles" value = "Admins" />Admins
	<input type = "radio" name = "roles" value = "All" />All
	<input type = "submit" value = "Checked"> 
	</form>
	</td>
</tr>

<tr>
<br>
	<td>Форма добавления пользователя</td>
</tr>
<tr>
	<td>
	<form action="http://localhost:8080/erkin_bokushev_web/users" method="get">
	<p>Name <input type = "text" name = "name"></p>
	<p>Login <input type = "text" name = "login"></p>
	<p>Passw <input type = "password" name = "pass"></p>
	<p>Answer <input type = "checkbox" name = "Answer" value = "Answer">
	Manage <input type = "checkbox" name = "Manage" value = "Manage">
	Director <input type = "checkbox" name = "Director" value = "Director">
	Admin <input type = "checkbox" name = "Admin" value = "Admin"></p>
	<p><input type = "reset" value = "Reset">
	<input type = "submit" value = "Add new user">
	</p>
	</form>
	</td>
</tr>
<tr>
	<td><% 
	
	if (request.getAttribute("alert")== null) {
		out.println("");
	} else {
		String alert = (String)request.getAttribute("alert"); 
		out.println(alert);
	}
	
	%>
</tr>
<tr>
	<td id = "footer"></td>
</tr>
</table>


</body>
</html>