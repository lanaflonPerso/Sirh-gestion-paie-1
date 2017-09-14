package fr.contrleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/connexion")
public class ConnctionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/views/employes/creerEmploye.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println( request.getParameter("matricule"));
		System.out.println(request.getParameter("entreprise"));
		System.out.println(request.getParameter("grade"));
		System.out.println(request.getParameter("profil"));
	}

}
