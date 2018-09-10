package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;

public class EditerCollaborateurController extends HttpServlet {
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	private DepartementService departService = Constantes.DEPART_SERVICE;
	protected String matricule;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.matricule = req.getParameter("matricule");
		List<Departement> departements = departService.listerDepartements();
		req.setAttribute("departements", departements);

		Collaborateur collaborateur = null;
		for (Collaborateur c : collabService.listerCollaborateurs()) {
			if (c.getMatricule().toString().equals(matricule)) {
				collaborateur = c;
			}
		}

		if (collaborateur == null) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.sendRedirect("lister");
		} else {
			resp.setStatus(HttpServletResponse.SC_ACCEPTED);
			req.setAttribute("collaborateur", collaborateur);
			req.getRequestDispatcher("/WEB-INF/views/collab/editerCollaborateur.jsp").forward(req, resp);
		}

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
			newCollab.setEmailPro(params.get(1).toLowerCase() + "." + params.get(0).toLowerCase() + "@societe.com");
			newCollab.setMatricule();
			newCollab.setNom(params.get(0));
			newCollab.setNumeroSecuriteSociale(Long.parseLong(params.get(4)));
			newCollab.setPhoto("/sgp/profil.png");
			newCollab.setPrenom(params.get(1));
			newCollab.setDepartement(Constantes.DEPART_SERVICE.getDepartementFromName(req.getParameter("departement")));
			newCollab.setIntitulePoste(req.getParameter("intitule"));
			Constantes.COLLAB_SERVICE.updateCollaborateur(newCollab, matricule);

			resp.sendRedirect("lister");
		}
	}
}
