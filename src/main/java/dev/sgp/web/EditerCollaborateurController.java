package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matriculeParam = req.getParameter("matricule");
		if (matriculeParam == null) {
			resp.sendError(400, "Un matricule est attendu");
		}
		else {
			resp.getWriter().write("<h1>Edition de collaborateur</h1>");
			resp.getWriter().write("Matricule : " + matriculeParam);

		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<String> params = new ArrayList<>();
		params.add(req.getParameter("matricule"));
		params.add(req.getParameter("titre"));
		params.add(req.getParameter("nom"));
		params.add(req.getParameter("prenom"));
		
		if (params.indexOf(null) == -1) {
			resp.getWriter().write("Création d'un collaborateur avec les informations suivantes : ");
			resp.getWriter().write("matricule=" + params.get(0) + ", titre=" + params.get(1) + ", nom=" + params.get(2) + ", prenom=" + params.get(3));		
			resp.setStatus(HttpServletResponse.SC_CREATED);
		}
		else  {
			resp.sendError(400, "Il manque au moins un paramètre");
		}
		
	
	}
}
