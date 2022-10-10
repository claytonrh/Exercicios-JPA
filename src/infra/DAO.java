package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> { // o <E> é de Entidade, a letra em si não tem nenhuma função, mas ao fazer isso...
						//...a classe se torna Genrics e poderá ser utilizada em qualqer outra entidade futuramente...
						//...ao invocar o DAO você pode decidir se quer invocar um DAO de Produto, Usuario, Cliente etc...

	private static EntityManagerFactory emf; //atributos de instancia, normalmente eles são inicializados pelo construtor...
	private EntityManager em; //...porém atributos de instancia, ou são inicializados na aqui na propria declaração ou em um bloco estático.
	private Class<E> classe;
	
	// exemplo de bloco estático, o bloco é executado uma unica vez quando a classe é carregada pelo java. 
	static {
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) {
			// logar -> log4j
		}
	}

	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	public DAO<E> abrirTransacao () {  //quando criamos um metodo que retorna a propria classe atual é possivel chamar este metodo de forma encadeada
		em.getTransaction().begin();  //...gerar um encadeamento de chamadas de métodos dentro de uma mesma sentença.
		return this;
	}
	
	public DAO<E> fecharTransacao () {  
		em.getTransaction().commit();  
		return this;
	}
	
	public DAO<E> incluir (E entidade) {  
		em.persist(entidade);  
		return this;
	}
	public DAO<E> incluirAtomico (E entidade) {		  
		return this.abrirTransacao().incluir(entidade).fecharTransacao();
	}
	
	public E obterPorId(Object id) {
		return em.find(classe, id);
	}
	
	public List<E> obterTodos () {
		return this.obterTodos(10, 0);
	}
	
	public List<E> obterTodos (int qtde, int deslocamento) {  //qtde e deslocamento = limit e offset do SQL(qtd e a partir de q ponto da lista)
		if (classe == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		
		String jpql = "select e from " + classe.getName() + " e"; // em JPA toda consulta é feita em jpql e não SQL, as consultas são....
		TypedQuery<E> query = em.createQuery(jpql, classe);		//.... sempre feitas em cima das classes/objetos e não nas tabelas do DB
		query.setMaxResults(qtde);
		query.setFirstResult(deslocamento);
		return query.getResultList();
	}
	
	public List<E> consultar(String nomeConsulta, Object... params) {
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
		
		for (int i = 0; i < params.length; i += 2) {  // irá pular de 2 em 2 prq no indice 0 tem o nome do parametro e no indice 1 o valor 
			query.setParameter(params[i].toString(), params[i + 1]);
		}
		
		return query.getResultList();
	}
	
	public E consultarUm(String nomeConsulta, Object... params) {
		List<E> lista = consultar(nomeConsulta, params);
		return lista.isEmpty() ? null : lista.get(0); // se lista for vazio retorne nulo : caso contrario retorne zero.
				
	}
	
	public void fechar () {
		em.close();
	}
}
