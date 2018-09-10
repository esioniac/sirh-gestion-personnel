<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-
dist/css/bootstrap.css">
</head>
<body>
	<h1>Editer un collaborateur</h1>
 	<c:set var="c" value="${collaborateur }" /> 
	<form action="/sgp/collaborateurs/editer" method="post">
		<p> Nom : <input type="text" value="${c.nom}" name="nom"/> </p>
		<p> Prénom : <input type="text" value="${c.prenom }" name="prenom"/> </p>
		<p> Date de naissance : <input type="date" value="${c.dateNaissance }" name="date" /> </p>
		<p> Adresse : <input type="text" value="${c.adresse }" name="adresse" /> </p>
		<p> Numéro de sécurité sociale : <input type="text" value="${c.numeroSecuriteSociale }" name="num" /> </p>
		<span> Département : </span>
			<select name="departement" size="1">
	      		<c:forEach items="${departements}" var="departement">
	      			<c:choose>
		      			<c:when test="${c.departement.nom == departement.nom}">
			   				<option selected><c:out value="${ departement.nom }" /></option>
			   			</c:when>
			   			
			   			<c:otherwise>
			   				<option><c:out value="${ departement.nom }" /></option>
			   			</c:otherwise>
		   			</c:choose>
		    	</c:forEach>
			</select>
		<p> Intitulé de poste : <input type="text" value="${c.intitulePoste }" name="intitule" /> </p>
		<p><input type="submit"  value="Valider" /></p>		
	</form>
</body>
</html>