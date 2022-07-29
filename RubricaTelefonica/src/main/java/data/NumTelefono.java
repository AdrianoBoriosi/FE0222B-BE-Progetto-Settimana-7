package data;


@Entity
@Table(name="numtelefono")
public class NumTelefono {
    
	private String numTelefono;
	private Contatto contatto;
	
	@Id
	@Column(name="numtel")
	public String getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	@ManyToOne
	@JoinColumn(name="id")
	public Contatto getContatto() {
		return contatto;
	}
	public void setContatto(Contatto contatto) {
		this.contatto = contatto;
	}
	@Override
	public String toString() {
		return "NumTelefono [numTelefono=" + numTelefono + ", contatto=" + contatto + "]";
	} 
	
	
}