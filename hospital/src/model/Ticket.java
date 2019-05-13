package model;

import java.util.Date;


public class Ticket {
	private int idT;
	private String libelle;
	private Date dateTicket;
	public Specialite specialite,specialite2;
	private double montant;
	private Patient patient,patient2;
	public Ticket idC;
	public Caissier caiss, caiss2;
	
	
	public Ticket(int idT, String libelle, Date dateTicket, Specialite specialite, double montant, Patient patient, Ticket idC, Caissier caiss){
		super();
		this.idT = idT;
		this.libelle = libelle;
		this.dateTicket = dateTicket;
		this.specialite = specialite;
		this.montant = montant;
		this.patient = patient;
		this.idC=idC;
		this.caiss=caiss;
		
	}


	public Ticket(int parseInt, String parameter, String parameter2, Specialite specialite2, Patient patient2,
			Caissier caiss2) {
		this.caiss2=caiss2;
		this.specialite2=specialite2;
		this.patient2=patient2;
		
	}


	public Specialite getSpecialite2() {
		return specialite2;
	}


	public void setSpecialite2(Specialite specialite2) {
		this.specialite2 = specialite2;
	}


	public Patient getPatient2() {
		return patient2;
	}


	public void setPatient2(Patient patient2) {
		this.patient2 = patient2;
	}


	public Caissier getCaiss() {
		return caiss;
	}


	public void setCaiss(Caissier caiss) {
		this.caiss = caiss;
	}


	public Caissier getCaiss2() {
		return caiss2;
	}


	public void setCaiss2(Caissier caiss2) {
		this.caiss2 = caiss2;
	}


	public int getIdT() {
		return idT;
	}

	public void setIdT(int idT) {
		this.idT = idT;
	}
	
	public Ticket getIdC() {
		return idC;
	}

	public void setIdC(Ticket idC) {
		this.idC = idC;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDateTicket() {
		return dateTicket;
	}

	public void setDateTicket(Date dateTicket) {
		this.dateTicket = dateTicket;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void setId(int int1) {
	
	}

	public void setCaissier(Caissier c) {
		
		this.caiss=c;
	}


	
	

}
