package modelo.heranca;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // para cada classe concreta ter� uma tabela
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE) // ir� criar apenas uma tabela discriminando em uma coluna o tipo do objeto  
@Inheritance(strategy = InheritanceType.JOINED) //ir� criar tamb�m uma tabela para cada classe mas os dados n�o ficaram duplicados, uma das tabelas receber� um PK que se tornar� uma FK
@DiscriminatorColumn(name = "tipo", length = 2, discriminatorType = DiscriminatorType.STRING) // � obrigat�rio esta anota��o para a estrat�gia SingleTable
@DiscriminatorValue("AL") // esse ser� o "tipo" dessa classe de aluno "AL = Aluno Normal"
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
