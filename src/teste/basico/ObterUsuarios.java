package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterUsuarios {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");    
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select u from Usuario"; // jpql = Java Persistent Query Lenguage, substitui a linguagem SQL ao usar JPA
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class); // .class é uma esécia de metadados do objeto, ela permite pegar os atributos do objeto
		query.setMaxResults(5);
		
		List<Usuario> usuarios = query.getResultList();
		
		for(Usuario usuario: usuarios) {
			System.out.println("ID " + usuario.getId()
					+ " E-mail: " + usuario.getEmail());
		}
		
		em.close();
		emf.close();
	}

}
