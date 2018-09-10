package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;

public class CollaborateurService {
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();

	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		listeCollaborateurs.add(collab);
	}
	
	public void updateCollaborateur(Collaborateur collab, String matricule) {
		Collaborateur collabo = getCollaborateurFromID(matricule);
		listeCollaborateurs.set(listeCollaborateurs.indexOf(collabo), collab);
	}
	
	public Collaborateur getCollaborateurFromID(String matricule) {
		for (Collaborateur c : listerCollaborateurs()) {
			if (c.getMatricule().toString().equals(matricule)) {
				return c;
			}
		}
		return null;
	}

}