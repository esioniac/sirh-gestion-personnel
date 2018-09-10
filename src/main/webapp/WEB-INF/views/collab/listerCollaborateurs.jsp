<%@page import="dev.sgp.util.Constantes"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="dev.sgp.entite.Departement"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-
dist/css/bootstrap.css">
</head>
<body>
	<h1>Les collaborateurs</h1>
	<span>Rechercher un nom qui commence par : </span>
	<input type="text" name="filtre" />
	<input type="submit" value="Rechercher" />
	<div></div>
	<span> Filtrer par département : </span>
	<select>
	  <option selected> Tous </option>
      	<c:forEach items="${departements}" var="departement">
	   		<option><c:out value="${ departement.nom }" /></option>
	    </c:forEach>
	</select>
	<ul>
		<c:forEach items="${collaborateurs}" var="collab">
		<li>
			<img src="${collab.photo}" alt="photo" width="100px" />
			<c:out value="${collab.nom} ${collab.prenom}, ${collab.dateNaissance}. ${collab.emailPro}. ${collab.departement.nom}, ${collab.intitulePoste}" />
 			<a style="margin: 0 30px 5px 0" href="editer?matricule=${collab.matricule}" class="btn btn-info pull-right" role="button" aria-pressed="true">Editer</a>
		</li>
		</c:forEach>
	</ul>
</body>
</html>