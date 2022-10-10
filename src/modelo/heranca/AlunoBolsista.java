package modelo.heranca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AL") // esse ser� o "tipo" dessa classe de aluno "AL = Aluno Normal"...isso � necess�rio na estrat�gia de heran�a SingleTable
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
