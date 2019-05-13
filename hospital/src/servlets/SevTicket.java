package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.InterCaissier;
import interfaces.InterPatient;
import interfaces.InterSpecialite;
import interfaces.InterTicket;
import model.Caissier;
import model.Patient;
import model.Specialite;
import model.Ticket;

/**
 * Servlet implementation class SevTicket
 */
@WebServlet("/SevTicket")
public class SevTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  	 Ticket m;
		 List<Ticket> listeM;
		 List<Caissier> listeC;
		 List<Specialite> listeS;
		 List<Patient> listeP;
		 Caissier caiss;
		 Specialite specialite;
		 Patient patient;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SevTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       String instruction = request.getParameter("ins");
		
	    
		if(instruction==null)
		{      
			
            listeM =  InterTicket.liste();
		    listeC = InterCaissier.liste();
		    listeP = InterPatient.liste();
		    listeS = InterSpecialite.liste();
			request.setAttribute("listeMedecins", listeM);
			request.setAttribute("listeCaisse", listeC);
			request.setAttribute("listeSpecialite", listeS);
			request.setAttribute("listePatient", listeP);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Ticket/index.jsp").forward(request, response);
		}else if(instruction.equals("delete")) {
			
		     int id = Integer.parseInt(request.getParameter("id"));
		     
		     int ok =  InterTicket.delete(id);
		        listeM =  InterTicket.liste();
			    listeC = InterCaissier.liste();
			    listeP = InterPatient.liste();
			    listeS = InterSpecialite.liste();
				request.setAttribute("listeMedecins", listeM);
				request.setAttribute("listeCaisse", listeC);
				request.setAttribute("listeSpecialite", listeS);
				request.setAttribute("listePatient", listeP);
		     
		     if(ok == 1)
				{
					request.setAttribute("message","Ce Tiket a bien ete supprimer");
				}else {
					request.setAttribute("message","Un probleme est survenu lors de la suppression du Tiket");
			   }
			this.getServletContext().getRequestDispatcher("/WEB-INF/Ticket/index.jsp").forward(request, response);
		 
		     }
		else {
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		caiss = new Caissier(Integer.parseInt(request.getParameter("id")), "", "", "", "", "", "", "", listeM);
		patient =new Patient(Integer.parseInt(request.getParameter("id")), "", "", "", "", "", "");
		specialite = new Specialite(Integer.parseInt(request.getParameter("id_s")),"", 0);
		
		m  = new Ticket(Integer.parseInt(request.getParameter("id")),request.getParameter("code"),request.getParameter("date"),specialite,patient,caiss);
		
		int id = Integer.parseInt(request.getParameter("id"));
		if(id==0)
		{
		int test =  InterTicket.verifiee(request.getParameter("code"));
	
		if(test < 1)
		{
								try {
								
									int ok =  InterTicket.genererTicket(m);
				
								        listeM =  InterTicket.liste();
									    listeC = InterCaissier.liste();
									    listeP = InterPatient.liste();
									    listeS = InterSpecialite.liste();
										request.setAttribute("listeMedecins", listeM);
										request.setAttribute("listeCaisse", listeC);
										request.setAttribute("listeSpecialite", listeS);
										request.setAttribute("listePatient", listeP);
									if(ok == 1)
									{
										request.setAttribute("message","Ticket ajouter avec succees !");
									}else {
										request.setAttribute("message","Probleme d'inserton de Ticket !");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								this.getServletContext().getRequestDispatcher("/WEB-INF/Ticket/index.jsp").forward(request, response);
				}else {
					
				        listeM =  InterTicket.liste();
					    listeC = InterCaissier.liste();
					    listeP = InterPatient.liste();
					    listeS = InterSpecialite.liste();
						request.setAttribute("listeMedecins", listeM);
						request.setAttribute("listeCaisse", listeC);
						request.setAttribute("listeSpecialite", listeS);
						request.setAttribute("listePatient", listeP);
		             request.setAttribute("message","cette matricule existe deja!");
	
					
					this.getServletContext().getRequestDispatcher("/WEB-INF/Ticket/index.jsp").forward(request, response);
				}
		}else {
		
    
			request.setAttribute("listeMedecins", listeM);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/Ticket/index.jsp").forward(request, response);
		}

	}

}
