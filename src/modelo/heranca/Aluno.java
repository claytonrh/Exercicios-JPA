package modelo.heranca;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // para cada classe concreta terá uma tabela
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE) // irá criar apenas uma tabela discriminando em uma coluna o tipo do objeto  
@Entity
@Inheritance(strategy = InheritanceType.JOINED) //irá criar também uma tabela para cada classe mas os dados não ficaram duplicados, uma das tabelas receberá um PK que se tornará uma FK
@DiscriminatorColumn(name = "tipo", length = 2, discriminatorType = DiscriminatorType.STRING) // é obrigatório esta anotação para a estratégia SingleTable
@DiscriminatorValue("AL") // esse será o "tipo" dessa classe de aluno "AL = Aluno Normal"
public class Aluno {

	@Id
	private Long matricula;
	
	private String nome;

	public Aluno() {

	}

	public Aluno(Long matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
