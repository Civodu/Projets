package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.InterPatient;
import model.Patient;

/**
 * Servlet implementation class SevPatient
 */
@WebServlet("/SevPatient")
public class SevPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
Patient m;
	
    List<Patient> listeM;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SevPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String instruction = request.getParameter("ins");
		

		if(instruction==null)
		{      
			
            listeM =  InterPatient.liste();
		    
			request.setAttribute("listeMedecins", listeM);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Patient/index.jsp").forward(request, response);
		}else if(instruction.equals("delete")) {
			
		     int id = Integer.parseInt(request.getParameter("id"));
		     
		 
		     int ok =  InterPatient.delete(id);
		   
			 listeM =  InterPatient.liste();
			 request.setAttribute("listeMedecins", listeM);
		     
		     if(ok == 1)
				{
					request.setAttribute("message","Patient supprimer avec succees !");
				}else {
					request.setAttribute("message","Probleme suppression de patient !");
			   }
			this.getServletContext().getRequestDispatcher("/WEB-INF/Patient/index.jsp").forward(request, response);
		}else if(instruction.equals("modifier"))  {
			
			
			listeM =  InterPatient.recup(Integer.parseInt(request.getParameter("id")));
		    
			request.setAttribute("listeMedecins", listeM);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Patient/modifier.jsp").forward(request, response);
		}
		else {
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		m  = new Patient(Integer.parseInt(request.getParameter("id")),request.getParameter("matricule"),request.getParameter("nom"),request.getParameter("dateNaisse")
				,request.getParameter("tel"),request.getParameter("sexe"),request.getParameter("gs")
				);
		

	
		
		int id = Integer.parseInt(request.getParameter("id"));
		if(id==0)
		{
		int test =  InterPatient.verifiee(request.getParameter("matricule"));
	
		if(test < 1)
		{
								try {
								
									int ok =  InterPatient.ajouter(m);
				
									listeM =  InterPatient.liste();
								    
									request.setAttribute("listeMedecins", listeM);
									if(ok == 1)
									{
										request.setAttribute("message","Patient ajouter avec succees !");
									}else {
										request.setAttribute("message","Probleme d'inserton patient !");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								this.getServletContext().getRequestDispatcher("/WEB-INF/Patient/index.jsp").forward(request, response);
				}else {
		             listeM =  InterPatient.liste();
		             request.setAttribute("message","cette matricule existe deja!");
					request.setAttribute("listeMedecins", listeM);
					
					this.getServletContext().getRequestDispatcher("/WEB-INF/Patient/index.jsp").forward(request, response);
				}
		}else {
			int ok = InterPatient.update(m);
			listeM =  InterPatient.liste();
			 if(ok == 1)
			 {
				 request.setAttribute("message","Patient modifier!");
			 }else {
				 request.setAttribute("message","Patient non modifier!");
			 }
   
			request.setAttribute("listeMedecins", listeM);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/Patient/index.jsp").forward(request, response);
		}
		
		
		

	}

}
