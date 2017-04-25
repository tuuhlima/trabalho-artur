package si5.univas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import si5.univas.model.Cliente;
import si5.univas.model.Produto;

public class ProdutoDAO {

	private Connection connection;
	
	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public ProdutoDAO() throws DAOException {
		this.connection = ConnectionFactory.createConnection();
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
	
	public Produto findForUpdate(int code) throws DAOException {
		try {
			String sql = "SELECT * FROM produto WHERE cod = ? FOR UPDATE";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, code);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				Produto produto = new Produto();
				
				produto.setCod(code);
				produto.setNome(result.getString("nome"));
				produto.setQtd(result.getInt("qtd"));
				
				return produto;
			} else {
				return null;
			}
		} catch (SQLException exception) {
			throw new DAOException(exception);
		}
	}
	
	
	public ArrayList<Produto> pesquisarProduto() throws SQLException{
		
		String sql = "SELECT * FROM produto;";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ArrayList<Produto> listaProdutos = new ArrayList<>();
		
		ResultSet result = statement.executeQuery();
		
		while(result.next()){
			Produto produtos = new Produto();
			
			produtos.setCod(result.getInt("cod"));
			produtos.setNome(result.getString("nome"));
			produtos.setQtd(result.getInt("qtd"));
			
			listaProdutos.add(produtos);
		}
		return listaProdutos;
	}
	
	public void update(Produto produto) throws DAOException {
		try {
			String sql = "UPDATE produto set nome = ?, qtd = ? WHERE cod = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, produto.getNome());
			statement.setInt(2, produto.getQtd());
			statement.setInt(3, produto.getCod());
			
			statement.executeUpdate();
		} catch (SQLException exception) {
			throw new DAOException(exception);
		}
	}
	
	public void updateQtd(int code,int qtd) throws DAOException {
		try {
			String sql = "SELECT * FROM produto WHERE cod = ? FOR UPDATE";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, code);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				Produto produto = new Produto();
				
				produto.setCod(code);
				produto.setNome(result.getString("nome"));
				produto.setQtd(result.getInt("qtd")+qtd);
				
			}
		} catch (SQLException exception) {
			throw new DAOException(exception);
		}
	}
	
}
