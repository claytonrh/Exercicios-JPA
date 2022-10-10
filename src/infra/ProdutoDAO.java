package infra;

import modelo.basico.Produto;

public class ProdutoDAO extends DAO<Produto>{ // esta é uma outra forma de criar um DAO já especifico para produto e nela você....
												//....já define metodos especificos para Produto, como por exemplo aplicar desconto para todos os produtos...
													//...sem precisar trazer essa complexidade para a regra do negocio
	public ProdutoDAO() {
		super(Produto.class); //ao definir como supre o construtor não será o construtor padrão da classe atual...
							//...mas sim o contrutor super da classe "extends" 
	}
}
