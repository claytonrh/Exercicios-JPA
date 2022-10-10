package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Usuario usuario = em.find(Usuario.class, 1L);
		usuario.setNome("Leonardo Leitao");
		usuario.setEmail("leonardo@lanche.com.br");

//		em.merge(usuario); // esse é o metodo que faz o update no DB

		em.getTransaction().commit(); // mesmo que o merge não seja feito o update ocorrerá porque ao fazer uma "consulta" dentro do estado...
									  //... "transacional" o objeto entra em um estado gerenciado e eventualmente o sistema irá atualizar as alterações
									  //...feitas no objeto para a entidade do DB

		em.close();
		emf.close();
	}

}
