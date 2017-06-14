package si5.univas.BI;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;

import si5.univas.dao.DAOException;
import si5.univas.dao.PedidoDAO;
import si5.univas.entity.Cliente;
import si5.univas.entity.Item;
import si5.univas.entity.Pedido;
import si5.univas.entity.Produto;

public class PedidoBI {

	public void createOrder(Cliente client, ArrayList<Item> items,Pedido pedido) throws OrderException, ParseException {
		// try {
						
			pedido.setCliente(client);
			
			HashSet<Item> itemsSet = new HashSet<>(items);
			pedido.setItems(itemsSet);
			
			PedidoDAO pedidoDAO = new PedidoDAO();
			
			pedidoDAO.persist(pedido);

			
			
//			for (Item item : items) {
//				Produto produto = produtoDAO.findForUpdate(item.getCod_produto());
//				
//				if(produto != null && produto.getQtd() >= item.getQtd()) {
//					item.setCod_pedido(pedido.getCod());
//					itemDAO.insertItem(item);
//					
//					produto.setQtd(produto.getQtd() - item.getQtd());
//					produtoDAO.update(produto);
//				} else {
//					throw new OrderException(produto, item.getQtd());
//				}
//			}
//			connection.commit();
//		} catch (DAOException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	
}
