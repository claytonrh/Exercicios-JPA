package teste.umpramuitos;

import infra.DAO;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

public class ObterPedido {

	public static void main(String[] args) {
		
		DAO<Pedido> dao = new DAO<> (Pedido.class); // o DAO irá apontar para a classe Pedido e o Pedido.class permitirá consultar os dados de PEdido
		
		Pedido pedido = dao.obterPorId(1L);
		
		for(ItemPedido item: pedido.getItens()) {
			System.out.println("quantidade de itens: " + item.getQuantidade());
			System.out.println("nome do produto: " + item.getProduto().getNome());
			System.out.println("id do produto: " + item.getProduto().getId());
		}
		
		dao.fechar();
	}
}
