package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.InterMedecin;
import interfaces.InterSpecialite;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Caissier;
import model.Medecin;
import model.Patient;
import model.Personnel;
import model.Specialite;
import model.Ticket;


@WebServlet("/SevSpecialite")
public class SevSpecialite extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Specialite m;
	

    List<Specialite> listeM;

    public SevSpecialite() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String instruction = request.getParameter("ins");
			

			if(instruction==null)
			{      
				
	            listeM =  InterSpecialite.liste();
			    
				request.setAttribute("listeMedecins", listeM);
				this.getServletContext().getRequestDispatcher("/WEB-INF/Specialite/index.jsp").forward(request, response);
			}else if(instruction.equals("delete")) {
				
			     int id = Integer.parseInt(request.getParameter("id"));
			     
			 
			     int ok =  InterSpecialite.supprimerM(id);
			   
				 listeM =  InterSpecialite.liste();
				 request.setAttribute("listeMedecins", listeM);
			     
			     if(ok == 1)
					{
						request.setAttribute("message","Specialite supprimer avec succees !");
					}else {
						request.setAttribute("message","Probleme suppression Specialite !");
				   }
				this.getServletContext().getRequestDispatcher("/WEB-INF/Specialite/index.jsp").forward(request, response);
			}else if(instruction.equals("modifier"))  {
				
				
				listeM =  InterSpecialite.recup(Integer.parseInt(request.getParameter("id")));
			    
				request.setAttribute("listeMedecins", listeM);
				this.getServletContext().getRequestDispatcher("/WEB-INF/Specialite/modifier.jsp").forward(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		m  = new Specialite(Integer.parseInt(request.getParameter("id")),request.getParameter("nom"),Integer.parseInt(request.getParameter("tarif")));
		

	
		
		int id = Integer.parseInt(request.getParameter("id"));
		if(id==0)
		{
		int test =  InterMedecin.verifiee(request.getParameter("nom"));
	
		if(test < 1)
		{
								try {
								
									int ok =  InterSpecialite.ajouter(m);
									
									listeM =  InterSpecialite.liste();
								    
									request.setAttribute("listeMedecins", listeM);
									if(ok == 1)
									{
										request.setAttribute("message","Speciaite ajouter avec succees !");
									}else {
										request.setAttribute("message","Probleme d'inserton de specialite !");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								this.getServletContext().getRequestDispatcher("/WEB-INF/Specialite/index.jsp").forward(request, response);
				}else {
		             listeM =  InterSpecialite.liste();
		             request.setAttribute("message","cette matricule existe deja!");
					request.setAttribute("listeMedecins", listeM);
					
					this.getServletContext().getRequestDispatcher("/WEB-INF/Specialite/index.jsp").forward(request, response);
				}
		}else {
			int ok = InterSpecialite.modifier(m);
			listeM =  InterSpecialite.liste();
			 if(ok == 1)
			 {
				 request.setAttribute("message","Specialite modifier!");
			 }else {
				 request.setAttribute("message","Specialite non modifier!");
			 }
     
			request.setAttribute("listeMedecins", listeM);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/Specialite/index.jsp").forward(request, response);
		}
		
		

	
}

}
