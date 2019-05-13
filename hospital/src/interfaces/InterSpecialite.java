package interfaces;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.*;
import model.Caissier;
import model.Medecin;
import model.Patient;
import model.Personne;
import model.Personnel;
import model.Specialite;


public class InterSpecialite {
	
	static Specialite special;

	public InterSpecialite ()
	{
		
	}
	
	//method pour ajouter un Medecin
	public static int ajouter (Specialite special)
	{
		 
		int tmp = 0;
		 String req="insert into specialite values(null,'"+special.getNom()+"','"+special.getTarif()+"')";
		
		 try {
			
			 tmp = ConnexionBD.executeMAJ(req);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		 
		 return tmp;
	}
	
  
	
	//methode 
	
	public static int verifiee(String nom)
	{
		String req="select id from specialite where nom_s='"+nom+"'";
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
	
	public static List<Specialite>   listeSpecilites(int id)
	{
		ResultSet resultSet ;
		List<Specialite> listeSpecialite = new ArrayList<Specialite>();
		String req="select * from specialite where id='"+id+"'";
     
	
		try {
		  
			resultSet = ConnexionBD.requette(req);
			while(resultSet.next())
			{
				special=new Specialite(resultSet.getInt("id"), resultSet.getString("nom"),resultSet.getInt("tarif"));
				listeSpecialite.add(special);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return listeSpecialite;
	}
	public static List<Specialite> liste()
	{
		ResultSet resultSet ;
		List<Specialite> listeSpecialite = new ArrayList<Specialite>();
		String req="select * from specialite";

	     
		try {
			
			resultSet = ConnexionBD.requette(req);
			//System.out.print("sante serigne bi"+rs.getMetaData());
			
			while(resultSet.next())
			{
				special=new Specialite(resultSet.getInt("id"), resultSet.getString("nom"),resultSet.getInt("tarif"));
				listeSpecialite.add(special);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return listeSpecialite;
	}
	//methode pour supprimer un medecin
	
	public static  int supprimerM(int id)
	{
		
		int tmp=0;
		String req="Delete from specialite where id ='"+id+"'";

		try {
			
			tmp = ConnexionBD.executeMAJ(req);
		
			
		} catch (Exception e) {
			
		}
		return tmp;
	}
	
	//methode pour modfier un medecin
	public static int modifier(Specialite m)
	{
	
		int tmp = 0;
   
		String req="update specialite set nom='"+m.getNom()+"', nom='"+m.getNom()+"', tarif='"+m.getTarif()+"' where id ='"+m.getId()+"'";
		try {
			
			tmp = ConnexionBD.executeMAJ(req);
		} catch (Exception e) {
			e.printStackTrace();
		   
		}
		return tmp ;
	}

	public static List<Specialite> recup(int parseInt) {
		
		
		
		String req="SELECT*FROM specialite where id='"+parseInt+"'";
		
		
		ResultSet resultSet ;
		List<Specialite> l = new ArrayList<Specialite>();
		String req1="select * from specialite";

	     
		try {
			
			resultSet = ConnexionBD.requette(req1);
			
			while(resultSet.next())
			{
				special=new Specialite(resultSet.getInt("id"), resultSet.getString("nom"),resultSet.getInt("tarif"));
				l.add(special);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return l;
		
	}
	
}
