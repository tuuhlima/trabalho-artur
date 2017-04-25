package si5.univas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import si5.univas.model.Cliente;
import si5.univas.model.Pedido;

public class PedidoDAO {

	private Connection connection;
	
	public PedidoDAO() throws DAOException {
		this.connection = ConnectionFactory.createConnection();
	}
	
	public PedidoDAO(Connection connection) {
		this.connection = connection;
	}
	
	private int nextCode() throws DAOException {
		
		try {
			String sql = "SELECT nextval('seq_pedido')";
			ResultSet result = connection.createStatement().executeQuery(sql);

			if(result.next()) {
				return result.getInt(1);
			}
			
			throw new DAOException("Não foi possível pegar o valor da sequência");
		} catch (SQLException exception) {
			throw new DAOException(exception);
		}
	}
	
	public void insertPedido(Pedido pedido,Cliente cliente)throws DAOException, ParseException{
		
			try {
				pedido.setCod(nextCode());
				
				String sql = "INSERT INTO pedido (cod, cod_cliente,data) VALUES (?, ?,?)";
				
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, pedido.getCod());
				statement.setInt(2,cliente.getCod());
				
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date date = df.parse(pedido.getData());
		        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				statement.setDate(3,sqlDate);
				
				
				
				statement.executeUpdate();
			} catch (SQLException | ParseException exception) {
				throw new DAOException(exception);
			}
		}
  }
	

