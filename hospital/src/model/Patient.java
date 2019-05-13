package model;

import java.util.List;
import java.util.*;

public class Patient extends Personne{
	private String  GroupeSanguin;
    private List<Ticket> tickets;
    
	public Patient(int id, String matricule, String nom, String dateNaissance, String telephone, String sexe, String GroupSanguin) {
		super(id, matricule, nom, dateNaissance, telephone, sexe);
		
		this.GroupeSanguin = GroupeSanguin;
		
	}
	public String getGroupeSanguin() {
		return GroupeSanguin;
	}

	public void setGroupeSanguin(String groupeSanguin) {
		GroupeSanguin = groupeSanguin;
	}
	
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	

}
