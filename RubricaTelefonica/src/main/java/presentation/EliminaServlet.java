package presentation;

import java.io.IOException;

import business.RubricaEjb;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EliminaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    RubricaEjb rubrica;
    public EliminaServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	rubrica.elimina(Long.valueOf(request.getParameter("Id")));
	request.getServletContext().getRequestDispatcher("/operazioneCompl.html").forward(request, response);
	}

}