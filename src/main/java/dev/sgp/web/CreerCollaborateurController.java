package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.util.Constantes;

public class CreerCollaborateurController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/collab/registrationForm.jsp").forward(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> params = new ArrayList<>();
		params.add(req.getParameter("nom"));
		params.add(req.getParameter("prenom"));
		params.add(req.getParameter("date"));
		params.add(req.getParameter("adresse"));
		params.add(req.getParameter("num"));
		
		if (params.indexOf("") == -1 && params.get(4).length() == 15) {
			Collaborateur newCollab = new Collaborateur();
			newCollab.setActif(true);
			newCollab.setAdresse(params.get(3));
			newCollab.setDateNaissance(LocalDate.parse(params.get(2)));
			newCollab.setDateHeureCreation(ZonedDateTime.now());
			newCollab.setEmailPro(params.get(1).toLowerCase() + "." + params.get(0).toLowerCase() + "@societe.com");
			newCollab.setMatricule();
			newCollab.setNom(params.get(0));
			newCollab.setNumeroSecuriteSociale(Long.parseLong(params.get(4)));
			newCollab.setPhoto("/sgp/profil.png");
			newCollab.setPrenom(params.get(1));
			Constantes.COLLAB_SERVICE.sauvegarderCollaborateur(newCollab);
			
			resp.sendRedirect("lister");
			
		}
		
		else {
			resp.sendError(400, "Paramètre(s) manquant(s)");
		}
	}
	
	
}
