package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.InterCaissier;
import interfaces.InterMedecin;
import model.Caissier;
import model.Personnel;

/**
 * Servlet implementation class Cassier
 */

@WebServlet("/SevCaissier")

public class SevCaissier extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	    SevCaissier m;
	
	    Personnel personnel;
	    List<Caissier> listeM;
 
	public SevCaissier(int parseInt, String parameter, String parameter2, String parameter3, String parameter4,
				String parameter5, String parameter6, String parameter7) {
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		//response.setCharacterEncoding("UTF-8");

String instruction = request.getParameter("ins");
		
	    System.out.println(instruction);
	    
		if(instruction==null)
		{      
			
            listeM =  InterCaissier.liste();
		    
			request.setAttribute("listeMedecins", listeM);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Caissier/index.jsp").forward(request, response);
		}else if(instruction.equals("delete")) {
			
		     int id = Integer.parseInt(request.getParameter("id"));
		     String matricule = request.getParameter("f");
		 
		     int vrai =  InterCaissier.suppCaissier(id);
		     
		     vrai =InterCaissier.suppPersonnel(matricule);
			 listeM =  InterCaissier.liste();
			 request.setAttribute("listeMedecins", listeM);
		     
		     if(vrai == 1)
				{
					request.setAttribute("message","Caissier supprimer avec succees !");
				}else {
					request.setAttribute("message","Probleme de suppression du caissier !");
			   }
			this.getServletContext().getRequestDispatcher("/WEB-INF/Caissier/index.jsp").forward(request, response);
		}else if(instruction.equals("modifier")){
			
			
			listeM =  InterCaissier.recuperer(Integer.parseInt(request.getParameter("id")));
		    
			request.setAttribute("listeMedecins", listeM);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Caissier/modifier.jsp").forward(request, response);
		}
		else {
			// a detailler
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		m  = new SevCaissier(Integer.parseInt(request.getParameter("id")),request.getParameter("matricule"),request.getParameter("nom"),request.getParameter("dateNaisse")
				,request.getParameter("tel"),request.getParameter("sexe"),request.getParameter("password"),request.getParameter("login")
				);
		
		personnel = new Personnel(request.getParameter("matricule"), "Caissier");
	
		
		int id = Integer.parseInt(request.getParameter("id"));
		if(id==0)
		{
		int test =  SevCaissier.Verifiee(request.getParameter("matricule"));
	
		if(test < 1)
		{
								try {
								
									int ok = SevCaissier.ajouterCaisser(m);
									ok = SevCaissier.ajoutP(personnel);
									listeM =  SevCaissier.liste();
								    
									request.setAttribute("listeMedecins", listeM);
									if(ok == 1)
									{
										request.setAttribute("message","Caissier ajouter avec succees !");
									}else {
										request.setAttribute("message","Probleme d'inserton de Caissier !");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								this.getServletContext().getRequestDispatcher("/WEB-INF/Caissier/index.jsp").forward(request, response);
				}else {
		             listeM =  InterCaissier.liste();
		             request.setAttribute("message","cette matricule existe deja!");
					request.setAttribute("listeMedecins", listeM);
					
					this.getServletContext().getRequestDispatcher("/WEB-INF/Caissier/index.jsp").forward(request, response);
				}
		}else {
			int ok = InterCaissier.update(m);
			listeM =  InterCaissier.liste();
			 if(ok == 1)
			 {
				 request.setAttribute("message","Caissier modifier!");
			 }else {
				 request.setAttribute("message","Caissier non modifier!");
			 }
   
			request.setAttribute("listeMedecins", listeM);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/Caissier/index.jsp").forward(request, response);
		}

	}

	private static List<Caissier> liste() {
		
		return null;
	}

	private static int ajouterCaisser(SevCaissier m2) {
		
		return 0;
	}

	private static int ajoutP(Personnel personnel2) {
	
		return 0;
	}

	private static int Verifiee(String parameter) {
		
		return 0;
	}

	

}
