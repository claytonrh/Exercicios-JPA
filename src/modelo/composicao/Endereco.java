package modelo.composicao;

import javax.persistence.Embeddable;

@Embeddable             // essa anotação garante que os atributos dessa classe sejam incluidos em outras tabelas que compartilhem...
public class Endereco { // o mesmo dado em comum sem a necessidade de fazer as anotações de relacionamento (OneToMany, ManyToMany etc...) 
						// desde que 

	private String logradouro;
	private String complemento;		
	
	public Endereco() {
	
	}	
	
	public Endereco(String logradouro, String complemento) {
		super();
		this.logradouro = logradouro;
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
