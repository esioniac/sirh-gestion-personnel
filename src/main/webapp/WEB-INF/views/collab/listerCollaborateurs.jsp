<%@page import="dev.sgp.util.Constantes"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
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
	<ul>
		<%
			for (Collaborateur c : Constantes.COLLAB_SERVICE.listerCollaborateurs()) {
		%>
		<li><img src="<%=c.getPhoto() %>" alt="photo" width="100px" /> <%=c.getNom() + " " + c.getPrenom() + ", " + c.getDateNaissance() + ", " + c.getEmailPro()%></li>
		<%
			}
		%>
	</ul>
</body>
</html>