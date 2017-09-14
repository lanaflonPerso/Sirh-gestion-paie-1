<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>Liste employés</title>
</head>
<body>
<a href=<%=request.getContextPath()%>/mvc/employes/creer>Employés</a> <a href=<%=request.getContextPath()%>/mvc/bulletins/creer>Bulletins</a>
	<h1>Liste des employés</h1>

	<table style="width: 100%">
		<tr>
			<th>Date/heure création</th>
			<th>Matricule</th>
			<th>Grade</th>
		</tr>
		<c:forEach items="${listeEmployes}" var="employe">
			<tr>
				<td>Sep 12, 2017</td>
				<td>${employe.matricule}</td>
				<td>${employe.grade.code}</td>
			<tr/>
		</c:forEach>
	</table>

</body>
</html>
