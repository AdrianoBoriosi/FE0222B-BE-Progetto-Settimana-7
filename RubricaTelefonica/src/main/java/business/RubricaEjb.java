package business;

import java.util.List;

import javax.management.Query;

import data.Contatto;
import data.NumTelefono;

@Stateless
@LocalBean
public class RubricaEjb implements RubricaEjbRemote, RubricaEjbLocal {
	@PersistenceContext(name="RubricaTelefonica")
	EntityManager em;
   
	
	
    public RubricaEjb() {
    }
    
    public void inserisci(Contatto e) {
    	em.persist(e);	
    }
    
    public Contatto getContattoByCognome(String cognome) {
    	Contatto contatto=new Contatto();
    	Query query=em.createQuery("SELECT c FROM Contatto c WHERE c.cognome like :cognome");
    	query.setParameter("cognome", "%"+cognome+"%");
    	contatto=(Contatto)query.getSingleResult();
    return contatto;
    }
    
    public Contatto getContattoByNumero(String numero) {
    	Contatto contatto=new Contatto();
    	NumTelefono numeroTel=new NumTelefono();
    	numeroTel=em.find(NumTelefono.class, numero);
    	
    	contatto=numeroTel.getContatto();
    	return contatto;
    }
    
    public Contatto getContattoByID(Long id) {
    	Contatto contatto=new Contatto();
    	contatto=em.find(Contatto.class, id);
    	
    return contatto;
    }
    
    
    
   @SuppressWarnings("unchecked")
	public List<Contatto> getAllContatti() {
    	Query queryCont=em.createQuery("SELECT c FROM Contatto c");
    	List<Contatto>contatti=queryCont.getResultList();
    	return contatti;
    }
   

    public void elimina(Long id) { 
    	Contatto contatto=new Contatto();
    	contatto=getContattoByID(id);
    	em.remove(contatto);
    }
    
    public int eliminaNumPerContatto(Contatto contatto) {
    	
    	int numeroElimina=0;
    	for(NumTelefono numero : contatto.getNumTelefoni()) {

        	Query query=em.createQuery("DELETE FROM NumTelefono t where  t.numTelefono like :numero");
        	query.setParameter("numero",numero.getNumTelefono() );
        	numeroElimina=query.executeUpdate();
    	}
    	
    	return numeroElimina;
    	
    }
    
    public Contatto update(Contatto contatto) {                     //Ho ipotizzato che nel modifica i due vecchi numeri venissero eliminati per i più nuovi
    	   eliminaNumPerContatto(getContattoByID(contatto.getId()));  
    	   
    	return em.merge(contatto);
    }
	
	


}
