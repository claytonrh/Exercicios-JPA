package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {
	
	public static void main(String[] args) {
		
		Produto produto = new Produto("Bicicleta caloi", 2.988);
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.incluirAtomico(produto).fechar();	
		
		System.out.println("Id do Produto" + produto.getId());
	}

}
