package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Usuario usuario = em.find(Usuario.class, 1L);
		usuario.setNome("Djalma");
		usuario.setEmail("djalma@lanche.com.br");
		
		em.detach(usuario); // esse método desasocia o objeto tirando ele do modo gerenciado

		em.getTransaction().commit(); 		
		
		em.close();
		emf.close();
	}

}
