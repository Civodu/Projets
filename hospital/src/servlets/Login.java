package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interfaces.InterConnexion;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
    }
    	/**
    	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		String ins =(String) request.getParameter("ins");
    		if(ins==null)
    		{
    			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    		}else if(ins.equals("logout"))
    		{
    			HttpSession session = request.getSession();
    			session.invalidate();
    			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    		}else {
    			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    		}
    		
    	}

    	/**
    	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		String email = request.getParameter("email");
    		String password = request.getParameter("password");
    		String type = request.getParameter("type");
    		try {
    			String typeR = InterConnexion.controlEmail(email, password,type);
    		    System.out.print(typeR);
    			if(typeR!=null)
    			{
    				HttpSession session = request.getSession();
    			
    		        session.setAttribute("type", type);
 
    		        this.getServletContext().getRequestDispatcher("/WEB-INF/lien.jsp").forward(request, response);
    			}else {
    				request.setAttribute("message", "Login ou Mot de passe incorrect");
    				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    			}
    		} catch (Exception e) {
    			// TODO: handle exception
    			e.printStackTrace();
    		}
    	}

}
