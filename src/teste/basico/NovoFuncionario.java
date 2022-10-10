package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.composicao.Endereco;
import modelo.composicao.Funcionario;

public class NovoFuncionario {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		Endereco endereco = new Endereco("Marechal 175", "Esquina");

		Funcionario novoFuncionario = new Funcionario("Clayton", endereco);	
		
		em.getTransaction().begin();
		em.persist(novoFuncionario);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
