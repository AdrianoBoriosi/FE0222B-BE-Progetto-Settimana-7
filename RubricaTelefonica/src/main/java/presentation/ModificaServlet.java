package presentation;

import java.io.IOException;
import java.util.ArrayList;

import business.RubricaEjb;
import data.Contatto;
import data.NumTelefono;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModificaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @EJB
   RubricaEjb rubrica;
    public ModificaServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contatto c=rubrica.getContattoByID(Long.valueOf(request.getParameter("Id")));
		NumTelefono n1=new NumTelefono();
		NumTelefono n2=new NumTelefono();
		ArrayList<NumTelefono>numeri=c.getNumTelefoni(); 
		
	
			n1.setNumTelefono(request.getParameter("numtel1"));
			n2.setNumTelefono(request.getParameter("numtel2"));
			
		
			if(request.getParameter("cognome").equals("")) {
				
			}else {
				c.setCognome(request.getParameter("cognome"));	
			}
			if(request.getParameter("nome").equals("")) {
				
			}else {
				c.setNome(request.getParameter("nome"));	
			}
			
			if(request.getParameter("email").equals("")) {
				
			}else {
				c.setEmail(request.getParameter("email"));	
			}
			if(n1.getNumTelefono().equals("")) {
				
			}else {
				n1.setContatto(c);
				numeri.set(0, n1);
				System.out.println(numeri.toString());
			}
			if(n2.getNumTelefono().equals("")) {
				
			}else if(numeri.size()>1){
				n2.setContatto(c);
				numeri.set(1,n2);
			}else {
				n2.setContatto(c);
				numeri.add(n2);
			}
			c.setNumTelefoni(numeri);
		
			
				rubrica.update(c);
				request.getServletContext().getRequestDispatcher("/operazioneCompl.html").forward(request, response);
		
	
	}

}