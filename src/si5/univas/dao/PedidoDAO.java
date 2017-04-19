package si5.univas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import si5.univas.model.Cliente;
import si5.univas.model.Pedido;

public class PedidoDAO {

	private Connection connection;
	
	public PedidoDAO() throws DAOException {
		this.connection = ConnectionFactory.createConnection();
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
	
	public void insertPedido(Pedido pedido,Cliente cliente)throws DAOException{
		
		try {
			// Buscando o próximo valor da sequência e atribuindo ao objeto
			pedido.setCod(nextCode());
			
			String sql = "INSERT INTO pedido (cod_cliente,data) VALUES (?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,cliente.getCod());
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date data = new Date(df.parse(pedido.getData()).getTime());
			statement.setDate(2,data);
			
			statement.executeUpdate();
		} catch (SQLException | ParseException exception) {
			throw new DAOException(exception);
		}
  }
	
}
