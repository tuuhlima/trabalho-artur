package si5.univas.BI;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import si5.univas.dao.ConnectionFactory;
import si5.univas.dao.DAOException;
import si5.univas.dao.ItemDAO;
import si5.univas.dao.PedidoDAO;
import si5.univas.dao.ProdutoDAO;
import si5.univas.entity.Cliente;
import si5.univas.entity.Item;
import si5.univas.entity.Produto;

public class ProdutoBI {

	public void atualizaSaldo(ArrayList<Produto> produtos) throws OrderException, ParseException, DAOException {
		
			Connection connection = ConnectionFactory.createConnection();
			
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
						
			for (Produto produto: produtos) {
				produtoDAO.update(produto);
			}	
	}	
}