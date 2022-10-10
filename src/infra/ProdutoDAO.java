package infra;

import modelo.basico.Produto;

public class ProdutoDAO extends DAO<Produto>{ // esta � uma outra forma de criar um DAO j� especifico para produto e nela voc�....
												//....j� define metodos especificos para Produto, como por exemplo aplicar desconto para todos os produtos...
													//...sem precisar trazer essa complexidade para a regra do negocio
	public ProdutoDAO() {
		super(Produto.class); //ao definir como supre o construtor n�o ser� o construtor padr�o da classe atual...
							//...mas sim o contrutor super da classe "extends" 
	}
}
