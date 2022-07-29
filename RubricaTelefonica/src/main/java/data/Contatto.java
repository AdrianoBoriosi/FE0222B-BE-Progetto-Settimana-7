package data;

import java.util.ArrayList;

@Entity
@Table(name="contatto")

public class Contatto {
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private ArrayList<NumTelefono> numTelefoni;
	
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column (name="nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column (name="cognome")
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	@Column (name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(mappedBy="contatto",cascade = CascadeType.ALL)
	public ArrayList<NumTelefono> getNumTelefoni() {
		return numTelefoni;
	}
	public void setNumTelefoni(ArrayList<NumTelefono> numTelefoni) {
		this.numTelefoni = numTelefoni;
	}
	
}