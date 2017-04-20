package si5.univas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import si5.univas.model.Item;

public class ItemDAO {

	private Connection connection;
	
	public ItemDAO() throws DAOException {
		this.connection = ConnectionFactory.createConnection();
	}
	
	public ItemDAO(Connection connection) {
		this.connection = connection;
	}
	
	private int nextCode() throws DAOException {
		
		try {
			String sql = "SELECT nextval('seq_item')";
			ResultSet result = connection.createStatement().executeQuery(sql);

			if(result.next()) {
				return result.getInt(1);
			}
			
			throw new DAOException("Não foi possível pegar o valor da sequência");
		} catch (SQLException exception) {
			throw new DAOException(exception);
		}
	}
	
	public void insertItem(Item item)throws DAOException{
		
		try {
			// Buscando o próximo valor da sequência e atribuindo ao objeto
			item.setCod(nextCode());
			
			String sql = "INSERT INTO item (cod_produto,cod_pedido,qtd) VALUES (?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, item.getCod_produto());
			statement.setInt(2, item.getCod_pedido());
			statement.setInt(3, item.getQtd());
						
			statement.executeUpdate();
		} catch (SQLException exception) {
			throw new DAOException(exception);
		}
	}
	
}
