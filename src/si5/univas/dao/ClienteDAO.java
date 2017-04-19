package si5.univas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import si5.univas.model.Cliente;

public class ClienteDAO {

	private Connection connection;
	
	public ClienteDAO() throws DAOException {
		this.connection = ConnectionFactory.createConnection();
	}
	
	public ClienteDAO(Connection connection) {
		this.connection = connection;
	}
	
	private int nextCode() throws DAOException {
		
		try {
			String sql = "SELECT nextval('seq_cliente')";
			ResultSet result = connection.createStatement().executeQuery(sql);

			if(result.next()) {
				return result.getInt(1);
			}
			
			throw new DAOException("Não foi possível pegar o valor da sequência");
		} catch (SQLException exception) {
			throw new DAOException(exception);
		}
	}
	
	public void insertCliente(Cliente cliente)throws DAOException{
		
			try {
				// Buscando o próximo valor da sequência e atribuindo ao objeto
				cliente.setCod(nextCode());
				
				String sql = "INSERT INTO cliente (nome,email) VALUES (?,?)";
				
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1,cliente.getNome());
				statement.setString(2,cliente.getEmail());
				
				statement.executeUpdate();
			} catch (SQLException exception) {
				throw new DAOException(exception);
			}
	  }
		
		public ArrayList<Cliente> pesquisarClientes() throws SQLException{
			
			String sql = "SELECT * FROM cliente;";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ArrayList<Cliente> listaClientes = new ArrayList<>();
			
			ResultSet result = statement.executeQuery();
			
			while(result.next()){
				Cliente clientes = new Cliente();
				
				clientes.setCod(result.getInt("cod"));
				clientes.setNome(result.getString("nome"));
				clientes.setEmail(result.getString("email"));
				
				listaClientes.add(clientes);
				
			}
			return listaClientes;
		}
	
	}
	

