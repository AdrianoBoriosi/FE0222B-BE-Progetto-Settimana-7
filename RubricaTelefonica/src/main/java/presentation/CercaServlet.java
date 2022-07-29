package presentation;

import java.io.IOException;

import business.RubricaEjb;
import data.Contatto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CercaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    RubricaEjb rubrica;
    public CercaServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	HttpSession session=request.getSession();
 	Contatto contatto =new Contatto();
 	String azione="cerca";
		if(request.getParameter("azione").equals("cercaNumero")) {
 		contatto=rubrica.getContattoByNumero(request.getParameter("numtel"));
 	} else if(request.getParameter("azione").equals("cercaCognome")) {
 		contatto=rubrica.getContattoByCognome(request.getParameter("cognome"));
 		
		
 	}
		session.setAttribute("contatto", contatto);
		session.setAttribute("azione", azione);
 	request.getServletContext().getRequestDispatcher("/visualizza.jsp").forward(request, response);
	}

}