package interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.ConnexionBD;

import model.Caissier;
import model.GroupSanguin;
import model.Medecin;
import model.Personne;
import model.Personnel;

public class InterMedecin {
	

	static Medecin med;
	Personne pers;
	Caissier caiss;
	GroupSanguin gs ;

	public InterMedecin()
	{
		
	}
	
	
	//ajout d'un Medecin
	
	public static int ajouterMedecin (Medecin med)
	{
		 
		int tmp = 0;
		 String req="insert into medecin values(null,'"+med.getMatricule()+"','"+med.getNom()+"','"+med.getDateNaissance()+"','"+med.getTelephone()+"','"+med.getSexe()+"','"+med.getGrade()+"','"+med.getEmail()+"','"+med.getPassword()+"')";
		
		 try {
			
			 tmp = ConnexionBD.executeMAJ(req);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				 
		 return tmp;
	}
	
  public static int ajoutP(Personnel pr)
  {
	  int tmp = 0;
		
		 String req = "insert into personnel values(null,'"+pr.getMatricule()+"','"+pr.getFonction()+"')";
		
		 try {
			
			 tmp = ConnexionBD.executeMAJ(req);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		 return tmp;
  }
	
	//methode pour lister tout le medecinr
	public static int verifiee(String matricule)
	{
		String req="select id from medecin where matricule='"+matricule+"'";
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
	
	public static List<Medecin>   recup(int id)
	{
		ResultSet resultSet ;
		List<Medecin> myliste = new ArrayList<Medecin>();
		String req="select * from medecin where id='"+id+"'";
     
	
		try {
		  
			resultSet = ConnexionBD.requette(req);
			while(resultSet.next())
			{
				med=new Medecin(resultSet.getInt("id"), resultSet.getString("matricule"),resultSet.getString("nom"),resultSet.getString("dateNaisse"),resultSet.getString("tel"),resultSet.getString("sexe"), req, req, req);
				myliste.add(med);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		myliste.forEach(p->{
			System.out.println(p.getEmail());
		});
		return myliste;
	}
	//Liste de medecins
	public static List<Medecin> liste()
	{
		ResultSet resultSet ;
		List<Medecin> myliste = new ArrayList<Medecin>();
		String req="select * from medecin";

	     
		try {
			
			resultSet = ConnexionBD.requette(req);
						
			while(resultSet.next())
			{
				med=new Medecin(resultSet.getInt("id"), resultSet.getString("matricule"),resultSet.getString("nom"),resultSet.getString("dateNaisse"),resultSet.getString("tel"),resultSet.getString("sexe"), req, req, req);
				myliste.add(med);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return myliste;
	}
   	
	// supprimer un medecin
	public static  int suppMedecin(int id)
	{
		int tmp=0;
		String req="delete from medecin where id ='"+id+"'";

		try {
			
			tmp = ConnexionBD.executeMAJ(req);
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tmp;
	}
	
	public static  int deleteP(String matricule)
	{
		
		int tmp=0;

		String req="delete from personnel where matricule='"+matricule+"'";
		try {
			
			tmp = ConnexionBD.executeMAJ(req);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tmp;
	}
	//modifier un medecin
	
	public static int update(Medecin med)
	{
		int tmp = 0;
   
		String req="update medecin set nom='"+med.getNom()+"', dateNaisse='"+med.getDateNaissance()+"', tel='"+med.getTelephone()+"',sexe='"+med.getSexe()+"',grade='"+med.getGrade()+"',email='"+med.getEmail()+"',password='"+med.getPassword()+"' where id ='"+med.getId()+"'";
		try {
			
			tmp = ConnexionBD.executeMAJ(req);
		} catch (Exception e) {
			
			e.printStackTrace();
		   
		}
		return tmp ;
	}

}
