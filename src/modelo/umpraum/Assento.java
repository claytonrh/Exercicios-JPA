package modelo.umpraum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assentos")
public class Assento {
	
	@Id     												//define como sendo a PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) 	//auto incremento da chave
	private Long id;  // atributo
	
	private String nome; //atributo
	
	@OneToOne(mappedBy = "assento") // Essa � a forma de fazer o relacionamento direcional dentro do JPA, dentro da Classe "Cliente" existe....
	private Cliente cliente;		//...o atributo "assento", agora apontamos dentro da Classe "Assento" o atributo "cliente"
	
	public Assento() {	
	
	}

	public Assento(String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	 
	
}
