package modelo.heranca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AB") // esse será o "tipo" dessa classe de aluno "AB = Aluno Bolsista"...isso é necessário na estratégia de herança SingleTable
public class AlunoBolsista extends Aluno{

	private double valorBolsa;
	
	public AlunoBolsista() {
	
	}

	public AlunoBolsista(Long matricula, String nome, double valorBolsa) {
		super(matricula, nome);
		this.valorBolsa = valorBolsa;
	}

	public double getValorBolsa() {
		return valorBolsa;
	}

	public void setValorBolsa(double valorBolsa) {
		this.valorBolsa = valorBolsa;
	}
	
	
}
