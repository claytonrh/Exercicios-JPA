package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario1 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Usuario usuario = em.find(Usuario.class, 1L);
		usuario.setNome("Leonardo");
		usuario.setEmail("leonardo@lanche.com.br");

		em.merge(usuario); // esse � o metodo que faz o update no DB

		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
