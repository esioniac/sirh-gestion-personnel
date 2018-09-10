<%@page import="dev.sgp.util.Constantes"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="dev.sgp.entite.Departement"%>
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
	<span>Rechercher un nom qui commence par : </span>
	<input type="text" name="filtre" />
	<input type="submit" value="Rechercher" />
	<div></div>
	<span> Filtrer par département : </span>
	<select>
	  <option selected> Tous </option>
      <% 
      	List<Departement> departements = (List<Departement>) request.getAttribute("listeDeparts");
     	for (Departement d : departements) { 
      %>
      <OPTION> <%=d.getNom()%> </OPTION>
      <% } %>
	</select>
	<ul>
		<%
			List<Collaborateur> collabs = (List<Collaborateur>) request.getAttribute("listeCollabs");
			for (Collaborateur c : collabs) {
		%>
		<li>
			<img src="<%=c.getPhoto() %>" alt="photo" width="100px" />
			<%=c.getNom() + " " + c.getPrenom() + ", " + c.getDateNaissance() + ", " + c.getEmailPro() + ", " + c.getDepartement().getNom() + ", " + c.getIntitulePoste()%>
			<a style="margin: 0 30px 5px 0" href="editer?<%="matricule="+c.getMatricule() %>" class="btn btn-info pull-right" role="button" aria-pressed="true">Editer</a>
		</li>
		<%
			}
		%>
	</ul>
</body>
</html>