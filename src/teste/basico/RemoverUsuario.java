package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class RemoverUsuario {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, 0L);
		
		if(usuario != null) {  // toda a��o que gere uma altera��o no DB ela precisa estar num estado transacional
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();			
		}
		
		em.close();
		emf.close();
	}

}
