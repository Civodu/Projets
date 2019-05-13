package interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.ConnexionBD;

import model.Caissier;
import model.Patient;
import model.Specialite;
import model.Ticket;

public class InterTicket {

	static Specialite s;
	static Patient p;
	static Caissier c;
	static Ticket t;
	

	//generation des tickets
		public static  int genererTicket (Ticket t)
		{
			int tmp = 0;
			 String req="insert into ticket values(null,'"+"','"+t.getDateTicket()+"','"+t.getIdC()+"','"+ t.getSpecialite().getId()+"','"+t.getPatient().getId()+"')";
			 try {
				 tmp = ConnexionBD.executeMAJ(req);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			 return tmp;
		}
	
	//liste des tickets d'un caissier 
		
	public static List<Ticket> liste()
	{
		List<Ticket> listeTicket = new ArrayList<Ticket>();
		ResultSet resultSet;
	
		String req="Select * from ticket t join specialite s on t.id_specialite = s.id "
				+ "join patient p  on t.id_patient=p.id join caissier c on t.id_caisse = c.id  ";
	
		try {
			resultSet =  ConnexionBD.requette(req);
			System.out.println(resultSet.getMetaData());
			
			t=new Ticket(0, req, null, s, 0, p, t, c);
			s=new Specialite(0, req, 0);
			c=new Caissier(0, req, req, req, req, req, req, req, listeTicket);
			p = new Patient(0, req, req, req, req, req, req);
		    while(resultSet.next())
		    {   
		    	t.setId(resultSet.getInt("idT"));
		    	t.setDateTicket(resultSet.getDate("dateTicket"));
		    	s.setId(resultSet.getInt("idC"));
		    	s.setTarif(resultSet.getInt("tarif"));
		    	p.setMatricule(resultSet.getString("matricule"));
		    	p.setNom(resultSet.getString("nom"));
		    	p.setTelephone(resultSet.getString("telephone"));
		    	c.setMatricule(resultSet.getString("matricule"));
		    	c.setNom(resultSet.getString("nom"));
		    	t.setCaissier(c);
		    	t.setPatient(p);
		    	t.setSpecialite(s);
		    	listeTicket.add(t);
		    }
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeTicket;
	}

public static int verifiee(String idP)
{
	String req="select id from ticket where id_patient='"+idP+"'";
    int tmp =0;
	ResultSet resultSet ;
	try {
	  
		resultSet = ConnexionBD.requette(req);
        
		while(resultSet.next())
		{
			tmp = resultSet.getRow();
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return tmp;
}
public static  int delete(int id)
{
	
	int tmp=0;
	String req="Delete from ticket where id ='"+id+"'";

	try {
		
		tmp = ConnexionBD.executeMAJ(req);
			
	} catch (Exception e) {
		// TODO: handle exception
	}
	return tmp;
}

}
