package interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.ConnexionBD;

import model.Caissier;
import model.GroupSanguin;
import model.Personne;
import model.Personnel;
import servlets.SevCaissier;

public class InterCaissier {

	static Caissier caiss;
	Personne pers;

	GroupSanguin gs ;
	

	//method pour ajouter un caissier
	public static int ajouterCaisser (Caissier caiss)
	{
		 
		int tmp = 0;
		 String req="insert into caissier values(null,'"+caiss.getMatricule()+"','"+caiss.getNom()+"','"+caiss.getDateNaissance()+"','"+caiss.getTelephone()+"','"+caiss.getSexe()+"','"+caiss.getEmail()+"','"+caiss.getPassword()+"')";
		
		 try {
			
			 tmp = ConnexionBD.executeMAJ(req);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		 
		 return tmp;
	}
	
	//ajout d'un personnel
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
	
	public static int verifiee(String matricule)
	{
		String req="select id from caissier where matricule='"+matricule+"'";
		
        int tmp =0;
		ResultSet resultset ;
		try {
		  
			resultset = ConnexionBD.requette(req);
	        
			while(resultset.next())
			{
				tmp = resultset.getRow();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tmp;
	}
	
	public static List<Caissier>   listeCaissiers(int id)
	{
		ResultSet resultset ;
		List<Caissier> listeCaissier = new ArrayList<Caissier>();
		String req="select * from caissier where id='"+id+"'";
     
	
		try {
		  
			resultset = ConnexionBD.requette(req);
			while(resultset.next())
			{
				caiss= new Caissier(resultset.getInt("id"), resultset.getString("matricule"),resultset.getString("nom_c"),resultset.getString("dateNaisse"),resultset.getString("tel"),resultset.getString("sexe"),resultset.getString("password"),resultset.getString("email"), null);
				listeCaissier.add(caiss);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return listeCaissier;
	}

	public static List<Caissier> liste()
	{
		ResultSet resultset ;
		List<Caissier> listeCaissier = new ArrayList<Caissier>();
		String req="select * from caissier";

		try {
			
			resultset = ConnexionBD.requette(req);
			
			while(resultset.next())
			{
				caiss=new Caissier(resultset.getInt("id"), resultset.getString("matricule"),resultset.getString("nom_c"),resultset.getString("dateNaisse"),resultset.getString("tel"),resultset.getString("sexe"),resultset.getString("password"),resultset.getString("email"), null);
				listeCaissier.add(caiss);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return listeCaissier;
	}
	
	public static List<Caissier>   recuperer(int id)
	{
		ResultSet resultSet ;
		List<Caissier> myliste = new ArrayList<Caissier>();
		String req="select * from caissier where id='"+id+"'";
	
		try {
		  
			resultSet = ConnexionBD.requette(req);
			while(resultSet.next())
			{
				caiss=new Caissier(resultSet.getInt("id"), resultSet.getString("matricule"),resultSet.getString("nom_c"),resultSet.getString("dateNaisse"),resultSet.getString("tel"),resultSet.getString("sexe"),resultSet.getString("password"),resultSet.getString("email"), null);
				myliste.add(caiss);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return myliste;
	}
   	
	//suppression d'un caissier
	
	public static  int suppCaissier(int id)
	{
		
		int tmp=0;
		String req="Delete from caissier where id ='"+id+"'";

		try {
			
			tmp = ConnexionBD.executeMAJ(req);
		
		} catch (Exception e) {
		
		}
		return tmp;
	}
	
	public static  int suppPersonnel(String matricule)
	{
		
		int tmp=0;

		String req="Delete from personnel where matricule='"+matricule+"'";
		try {
			
			tmp = ConnexionBD.executeMAJ(req);
		
	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tmp;
	}
	
	//methode pour modfier un caissier
	public static int update(Caissier c)
	{
	
		int tmp = 0;
   
		String req="update caissier set nom='"+c.getNom()+"', dateNaisse='"+c.getDateNaissance()+"', telephone='"+c.getTelephone()+"',sexe='"+c.getSexe()+"',email='"+c.getEmail()+"',password='"+c.getPassword()+"' where id ='"+c.getId()+"'";
		try {
			
			tmp = ConnexionBD.executeMAJ(req);
		} catch (Exception e) {
			e.printStackTrace();
		   
		}
		return tmp ;
	}

	public static List<Caissier> recup(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}

	public static int update(SevCaissier m) {

		return 0;
	}
}
