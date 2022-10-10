package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {

	public static void main(String[] args) {
		
		Assento assento = new Assento("16A");
		Cliente cliente = new Cliente("Carlos", assento);
		
		DAO<Object> dao = new DAO<>(); //irá persistir os dois objetos no DB
		
		dao.abrirTransacao()
		.incluir(assento)  // como na tabela cliente existe a informação id_assento é necessário incluir...
		.incluir(cliente)  //...primeiro o assento para quando for incluir o cliente já ter a informação Id-assento
		.fecharTransacao();
	}
}
