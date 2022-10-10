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
	

	@OneToOne(cascade = CascadeType.PERSIST)// Essa anotation ir� criar no DB um atributo chamado "assento_id" que ser� a F.K que vir� da tabela Assento
											// isso ocorre porque dentro da classe Assento existe um mapeamento(entity) criando a tabela "assentos"
											// o "cascade" ir� fazer com que ao usar o metodo "IncluirAtomico" que n�o tem a informa��o de assento...
											//...(o que levaria ao erro de execu��o) ele ir� persitir tamb�m o assento
	
	@JoinColumn(name= "assento_id", unique=true)// Onde tem a anotation "OneToOne" n�o � possivel usar a anotation "Column" mas � possivel...
												//...usar o "JoinColumn" especifico para mapear campos que representam jun��o de tabelas....
												//...isso garantir� que n�o ser� poss�vel incluir o mesmo assento para outro cliente 
	
	private Assento assento; //Objeto; forma correta com O.O, ao criar um objeto voc� poder� ter acesso ao varios atributos que ele possa vir a ter 	
	
	// exemplo modelo usual de E.R
//	@Column(name ="assento_id") //esse n�o � o formato correto pois estaria trabalhando com a idea de E.R, o paradgmo que o DB segue    
//	private Long assentoId; 	// e na verdade a quando trabalho com o Java a idea � trabalhar no mode O.O
	
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
