<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" isELIgnored="false"%>
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
<%-- 	<%Collaborateur c = (Collaborateur) request.getAttribute("collaborateur"); %>
 --%>	<c:set var="c" value="${collaborateur }" /> 
	<form action="/sgp/collaborateurs/editer" method="post">
		<p> Nom : <input type="text" value="<%=c.getNom() %>" name="nom"/> </p>
		<p> Prénom : <input type="text" value="<%=c.getPrenom() %>" name="prenom"/> </p>
		<p> Date de naissance : <input type="date" value="<%=c.getDateNaissance() %>" name="date" /> </p>
		<p> Adresse : <input type="text" value="<%=c.getAdresse() %>" name="adresse" /> </p>
		<p> Numéro de sécurité sociale : <input type="text" value="<%=c.getNumeroSecuriteSociale() %>" name="num" /> </p>
		<p> Département : <input type="text" value="<%=c.getDepartement().getNom() %>" name="depart" /> </p>
		<p> Intitulé de poste : <input type="text" value="<%=c.getIntitulePoste() %>" name="intitule" /> </p>
		<p><input type="submit"  value="Valider" /></p>		
	</form>
</body>
</html>