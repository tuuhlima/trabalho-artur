package si5.univas.BI;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import si5.univas.dao.DAOException;
import si5.univas.dao.ItemDAO;
import si5.univas.dao.PedidoDAO;
import si5.univas.dao.ProdutoDAO;
import si5.univas.entity.Cliente;
import si5.univas.entity.Item;
import si5.univas.entity.Pedido;
import si5.univas.entity.Produto;



public class PedidoBI {

	/*
	 * aa
	 */
	
//	public void createOrder(Cliente client, ArrayList<Item> items,Pedido pedido) throws OrderException, ParseException {
//		try {
//			Connection connection = ConnectionFactory.createConnection();
//
//			connection.setAutoCommit(false);
//			
//			PedidoDAO pedidoDAO = new PedidoDAO(connection);
//			
//			pedido.setCod_cliente(client.getCod());
//			pedido.setData(pedido.getData());
//			
//			pedidoDAO.insertPedido(pedido,client);
//
//			ItemDAO itemDAO = new ItemDAO(connection);
//			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
//			
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
//	}
	
}
