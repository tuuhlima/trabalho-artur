package si5.univas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import si5.univas.model.Cliente;
import si5.univas.model.Item;
import si5.univas.model.Pedido;

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
			String sql = "INSERT INTO item (cod_pedido,cod_produto,qtd) VALUES (?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, item.getCod_pedido());
			statement.setInt(2, item.getCod_produto());
			statement.setInt(3, item.getQtd());
						
			statement.executeUpdate();
		} catch (SQLException exception) {
			throw new DAOException(exception);
		}
	}
	
	public ArrayList<Item> pesquisarItens() throws SQLException{
		
		String sql = "SELECT * FROM item;";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ArrayList<Item> listaItens = new ArrayList<>();
		
		ResultSet result = statement.executeQuery();
		
		while(result.next()){
			Item itens = new Item();
			
			itens.setCod(result.getInt("cod"));
			itens.setCod_pedido(result.getInt("cod_pedido"));
			itens.setCod_produto(result.getInt("cod_produto"));
			itens.setQtd(result.getInt("qtd"));
			
			listaItens.add(itens);
			
		}
		return listaItens;
	}
	
}
