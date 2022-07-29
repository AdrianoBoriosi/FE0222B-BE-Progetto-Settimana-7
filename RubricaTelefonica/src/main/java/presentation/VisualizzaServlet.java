package presentation;

import java.io.IOException;
import java.util.List;

import business.RubricaEjb;
import data.Contatto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class VisualizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB 
    RubricaEjb rubrica;
    public VisualizzaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String azione="visualizza";
		
		List<Contatto> contatti= rubrica.getAllContatti();
		HttpSession session=request.getSession();
		session.setAttribute("contatti", contatti);
		session.setAttribute("azione", azione);
		request.getServletContext().getRequestDispatcher("/visualizza.jsp").forward(request, response);
		
	}

}
