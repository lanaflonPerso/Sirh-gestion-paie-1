<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Creation d'un employe</title>

<link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body>

<h1>Créer employe</h1>
	<form method="post"
		action="http://localhost:8080/paie/mvc/employes/creer/">
		
		Matricule <input type="text" value="" name = matricule><br>
		Entreprise <select name=entrepriseId>
			<c:forEach items="${listeEntreprises}" var="entreprise">
				<option value="${entreprise.id}">${entreprise.denomination}</option>
			</c:forEach>
		</select> <br> 
		
		Profil <select name=profilId>
			<c:forEach items="${listeProfils}" var="profil">
				<option value="${profil.id}">${profil.code}</option>
			</c:forEach>
		</select> <br>
		
		Grade 
		<select name=gradeId>
			<c:forEach items="${listeGrades}" var="grade">
				<option value="${grade.id}">${grade.code} - ${grade.tauxBase * grade.nbHeuresBase * 12} € / an</option>
			</c:forEach>
		</select> <br>
		
		<br> <input type="submit" value="Submit">
	</form>


</body>
</html>

