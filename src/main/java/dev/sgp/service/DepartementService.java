package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Departement;

public class DepartementService {
	List<Departement> listeDepartements = new ArrayList<>();
	
	public DepartementService() {
		this.listeDepartements.add(new Departement(1, "Comptabilité"));
		this.listeDepartements.add(new Departement(2, "Ressources Humaines"));
		this.listeDepartements.add(new Departement(3, "Informatique"));
		this.listeDepartements.add(new Departement(4, "Administratif"));
	}

	public List<Departement> listerDepartements() {
		return listeDepartements;
	}

	public void sauvegarderDepartements(Departement depart) {
		listeDepartements.add(depart);
	}
	
	public Departement getDepartementFromName(String nom) {
		for (Departement d : listerDepartements()) {
			if (d.getNom().equals(nom)) {
				return d;
			}
		}
		return null;
	}
}