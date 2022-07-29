package business;

import java.util.List;

import data.Contatto;

@Local
public interface RubricaEjbLocal {
	  public void inserisci(Contatto e);
	  public Contatto getContattoByCognome(String cognome);
	  public List<Contatto> getAllContatti();
	  public void elimina(Long id);
	  public Contatto getContattoByID(Long id);
	  public Contatto update(Contatto contatto);
	  public Contatto getContattoByNumero(String numero);
}
