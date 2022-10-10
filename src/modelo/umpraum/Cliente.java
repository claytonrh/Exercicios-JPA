package modelo.umpraum;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id     												//define como sendo a PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) 	//auto incremento da chave
	private Long id;
	
	private String nome;
	

	@OneToOne(cascade = CascadeType.PERSIST)// Essa anotation irá criar no DB um atributo chamado "assento_id" que será a F.K que virá da tabela Assento
											// isso ocorre porque dentro da classe Assento existe um mapeamento(entity) criando a tabela "assentos"
											// o "cascade" irá fazer com que ao usar o metodo "IncluirAtomico" que não tem a informação de assento...
											//...(o que levaria ao erro de execução) ele irá persitir também o assento
	
	@JoinColumn(name= "assento_id", unique=true)// Onde tem a anotation "OneToOne" não é possivel usar a anotation "Column" mas é possivel...
												//...usar o "JoinColumn" especifico para mapear campos que representam junção de tabelas....
												//...isso garantirá que não será possível incluir o mesmo assento para outro cliente 
	
	private Assento assento; //Objeto; forma correta com O.O, ao criar um objeto você poderá ter acesso ao varios atributos que ele possa vir a ter 	
	
	// exemplo modelo usual de E.R
//	@Column(name ="assento_id") //esse não é o formato correto pois estaria trabalhando com a idea de E.R, o paradgmo que o DB segue    
//	private Long assentoId; 	// e na verdade a quando trabalho com o Java a idea é trabalhar no mode O.O
	
	public Cliente() {
	
	}

	public Cliente(String nome, Assento assento) {
		super();
		this.nome = nome;
		this.assento = assento;
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

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}
	
	
}
