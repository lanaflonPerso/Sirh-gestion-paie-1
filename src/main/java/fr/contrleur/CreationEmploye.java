package fr.contrleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


	@WebServlet("/creer")
	public class CreationEmploye extends HttpServlet {
		public static final String VUE = "/WEB-INF/creerEmploye.jsp";
		
		public static final String mat = "email";

	    public static final String entre = "entreprise";

	    public static final String prof = "profil";

	    public static final String grad = "grade";

	    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

	       

	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

	    }

	    

	    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

	    	String email= request.getParameter( mat);

	        String entreprise = request.getParameter( entre);

	        String profil = request.getParameter( prof );

	        String grade= request.getParameter( grad );



	    }
	
	
}
