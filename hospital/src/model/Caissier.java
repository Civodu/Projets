package model;

import java.util.List;

public class Caissier extends Personne{

    private String email;
    private String password;
	private List<Ticket> tickets;
	
	public Caissier(int id, String matricule, String nom, String dateNaissance, String telephone, String sexe,
			String email, String password, List<Ticket> tickets) {
		super(id, matricule, nom, dateNaissance, telephone, sexe);
		this.email = email;
		this.password = password;
		this.tickets = tickets;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	
	
}
