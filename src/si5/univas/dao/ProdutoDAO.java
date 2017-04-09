package si5.univas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import si5.univas.model.Cliente;
import si5.univas.model.Produto;

public class ProdutoDAO {

	
	private Connection connection;
	
	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}
	
	private int nextCode() throws DAOException {
		
		try {
			String sql = "SELECT nextval('seq_produto')";
			ResultSet result = connection.createStatement().executeQuery(sql);

			if(result.next()) {
				return result.getInt(1);
			}
			
			throw new DAOException("Não foi possível pegar o valor da sequência");
		} catch (SQLException exception) {
			throw new DAOException(exception);
		}
	}
	
	public void insertProduto(Produto produto)throws DAOException{
		
		try {
			// Buscando o próximo valor da sequência e atribuindo ao objeto
			produto.setCod(nextCode());
			
			String sql = "INSERT INTO produto (nome,qtd) VALUES (?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,produto.getNome());
			statement.setInt(2,produto.getQtd());
			
			statement.executeUpdate();
		} catch (SQLException exception) {
			throw new DAOException(exception);
		}
	}

	
}
