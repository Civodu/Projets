package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.InterMedecin;
import model.Medecin;
import model.Personnel;

/**
 * Servlet implementation class SevMedecin
 */
@WebServlet("/SevMedecin")
public class SevMedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Medecin m;
	    InterMedecin interM ;
	    Personnel personnel;
	    List<Medecin> listeM;
	    
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public SevMedecin() {
	        super();
	        // TODO Auto-generated constructor stub
	       
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			
			String instruction = request.getParameter("ins");
			
		    System.out.println(instruction);
			if(instruction==null)
			{      
				
	            listeM =  InterMedecin.liste();
			    
				request.setAttribute("listeMedecins", listeM);
				this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/index.jsp").forward(request, response);
			}else if(instruction.equals("delete")) {
				
			     int id = Integer.parseInt(request.getParameter("id"));
			     String matricule = request.getParameter("f");
			 
			     int tmp =  InterMedecin.suppMedecin(id);
			     tmp =InterMedecin.deleteP(matricule);
				 listeM =  InterMedecin.liste();
				 request.setAttribute("listeMedecins", listeM);
			     
			     if(tmp == 1)
					{
						request.setAttribute("message","Medecin supprimer avec succees !");
					}else {
						request.setAttribute("message","Probleme suppression de medecin !");
				   }
				this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/index.jsp").forward(request, response);
			}else if(instruction.equals("modifier"))  {
				
				
				listeM =  InterMedecin.recup(Integer.parseInt(request.getParameter("id")));
			    
				request.setAttribute("listeMedecins", listeM);
				this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/modifier.jsp").forward(request, response);
			}
			else {
				
			}
		
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			m  = new Medecin(Integer.parseInt(request.getParameter("id")),request.getParameter("matricule"),request.getParameter("nom"),request.getParameter("dateNaisse")
					,request.getParameter("tel"),request.getParameter("sexe"),request.getParameter("password"),request.getParameter("login")
					,request.getParameter("grade"));
			
			personnel = new Personnel(request.getParameter("matricule"), "Medecin");
		
			
			int id = Integer.parseInt(request.getParameter("id"));
			if(id==0)
			{
			int test =  InterMedecin.verifiee(request.getParameter("matricule"));
		
			if(test < 1)
			{
									try {
									
										int tmp =  InterMedecin.ajouterMedecin(m);
										tmp = InterMedecin.ajoutP(personnel);
										listeM =  InterMedecin.liste();
									    
										request.setAttribute("listeMedecins", listeM);
										if(tmp == 1)
										{
											request.setAttribute("message","Medecin ajouter avec succees !");
										}else {
											request.setAttribute("message","Probleme survenu lors de l'insertion du medecin !");
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
									this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/index.jsp").forward(request, response);
					}else {
			             listeM =  InterMedecin.liste();
			             request.setAttribute("message","cette matricule existe deja!");
						request.setAttribute("listeMedecins", listeM);
						
						this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/index.jsp").forward(request, response);
					}
			}else {
				int tmp = InterMedecin.update(m);
				listeM =  InterMedecin.liste();
				 if(tmp == 1)
				 {
					 request.setAttribute("message","Medecin modifier!");
				 }else {
					 request.setAttribute("message","Medecin non modifier !");
				 }
	     
				request.setAttribute("listeMedecins", listeM);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/index.jsp").forward(request, response);
			}
			
			
			
		}
}
