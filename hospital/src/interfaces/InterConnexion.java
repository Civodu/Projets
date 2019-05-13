package interfaces;

import java.sql.ResultSet;

import java.sql.ResultSet;

import com.db.*;
import model.Caissier;
import model.Medecin;
import model.Personnel;

public class InterConnexion {
	static Personnel pers;
	static Medecin med;
	static Caissier caiss;
	
	public static String controlEmail(String email,String password,String type)
	{  
		ResultSet resultset=null;
		String mail = "";
		int tmp = 0;
		String req = "select * from medecin med join Personnel pers on med.matricule=pers.matricule where email='"+email+"' and password='"+password+"'";
		String req2 = "select * from caissier med join Personnel pers on med.matricule=pers.matricule where email='"+email+"' and password='"+password+"'";
		if(type=="Medecin")
		{
			try {
				resultset = ConnexionBD.requette(req);
				if(resultset!=null)
				{
					while(resultset.next())
					{
						mail = resultset.getString("type");
					}
					
				}else {
					mail ="";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				resultset = ConnexionBD.requette(req2);
				if(resultset!=null)
				{
					while(resultset.next())
					{
						mail = resultset.getString("type");
					}
				}else {
					mail ="";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.print("adresse mail:"+mail);
		return mail;
		
	}
	

}
