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
public class InterPatient {
	public static Patient med;
	
	//method d'ajout du medecin
	
	public static int ajouter (Patient med)
	{
		 
		int oui = 0;
		 String req="insert into patient values(null,'"+med.getMatricule()+"','"+med.getNom()+"','"+med.getDateNaissance()+"','"+med.getTelephone()+"','"+med.getSexe()+"','"+med.getGroupeSanguin()+"')";
		
		 try {
			
			 oui = ConnexionBD.executeMAJ(req);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		 
		 return oui;
	}

	//liste de medecins
		public static int verifiee(String matricule)
		{
			String req="select id from patient where matricule='"+matricule+"'";
	        int ok =0;
			ResultSet rs ;
			try {
			  
				rs = ConnexionBD.requette(req);
		        
				while(rs.next())
				{
					ok = rs.getRow();
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return ok;
		}
		
		public static List<Patient>   recup(int id)
		{
			ResultSet rs ;
			List<Patient> myliste = new ArrayList<Patient>();
			String req="select * from patient where id='"+id+"'";
	 
			try {
			  
				rs = ConnexionBD.requette(req);
				while(rs.next())
				{
					med=new Patient(rs.getInt("id"), rs.getString("matricule"),rs.getString("nom_p"),rs.getString("dateNaisse"),rs.getString("tel"),rs.getString("sexe"),rs.getString("groupeSanguin"));
					myliste.add(med);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return myliste;
		}
		public static List<Patient> liste()
		{
			ResultSet resultsets ;
			List<Patient> myliste = new ArrayList<Patient>();
			String req="select * from patient";

			try {
				
				resultsets = ConnexionBD.requette(req);
				System.out.print("Bonjour"+resultsets.getMetaData());
				
				while(resultsets.next())
				{
					System.out.println(resultsets.getString("nom_p"));
					med=new Patient(resultsets.getInt("id"), resultsets.getString("matricule"),resultsets.getString("nom_p").toString(),resultsets.getString("dateNaisse"),resultsets.getString("tel"),resultsets.getString("sexe"),resultsets.getString("groupeSanguin"));
					myliste.add(med);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return myliste;
		}
	   	
		//suppression d'un medecin
		public static  int delete(int id)
		{
			
			int tmp=0;
			String req="Delete from patient where id ='"+id+"'";

			try {
				
				tmp = ConnexionBD.executeMAJ(req);
			
			} catch (Exception e) {
				// TODO: handle exception
			}
			return tmp;
		}

		//methode pour modfier un medecin
		public static int update(Patient m )
		{
			int tmp = 0;
			String req="update patient set nom_p='"+m.getNom()+"', dateNaisse='"+m.getDateNaissance()+"', tel='"+m.getTelephone()+"',sexe='"+m.getSexe()+"',groupeSanguin='"+m.getGroupeSanguin()+"' where id ='"+m.getId()+"'";
			try {
				
				tmp = ConnexionBD.executeMAJ(req);
			} catch (Exception e) {
				e.printStackTrace();
			   
			}
			return tmp ;
		}

}
