package si5.univas.controller;

import java.sql.Connection;
import java.util.Date;

import javax.swing.JOptionPane;

import si5.univas.dao.ConnectionFactory;
import si5.univas.dao.ClienteDAO;
import si5.univas.dao.DAOException;
import si5.univas.dao.ProdutoDAO;
import si5.univas.model.Cliente;
import si5.univas.model.Produto;
import si5.univas.view.TelaCadastro;
import si5.univas.view.TelaCadastroCliente;
import si5.univas.view.TelaCadastroProduto;

public class Controller {
	
	TelaCadastro telaCadastro = new TelaCadastro(this);
	TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente(this);
	TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto(this);
	
	public void iniciar(){
		telaCadastro.tela();
		
		telaCadastroCliente.tela();
		telaCadastroCliente.setVisible(false);
		
		telaCadastroProduto.tela();
		telaCadastroProduto.setVisible(false);
	}
	
	public void exit(){
		int resposta;
		resposta = JOptionPane.showConfirmDialog(null,"Deseja realmente sair?");
		if(resposta == JOptionPane.YES_OPTION){
			System.exit(0);
		}else{
			return;
		}	
	}
	
	public void cliente(){
		telaCadastro.setVisible(false);
		telaCadastroCliente.setVisible(true);
	}
	
	public void voltarCadastro(){
		telaCadastroProduto.setVisible(false);
		telaCadastroCliente.setVisible(false);
		telaCadastro.setVisible(true);
	}
	
	public void produto(){
		telaCadastro.setVisible(false);
		telaCadastroProduto.setVisible(true);
	}
	
	public void cadastroCliente(Cliente cliente) throws DAOException{
		
		Connection connection = ConnectionFactory.createConnection();
		
		// Inserir o Cliente
		ClienteDAO clienteDAO = new ClienteDAO(connection);		
		clienteDAO.insertCliente(cliente);
	}
	
	public void cadastroProduto(Produto produto) throws DAOException{
		
		Connection connection = ConnectionFactory.createConnection();
		
		ProdutoDAO produtoDAO = new ProdutoDAO(connection);
		produtoDAO.insertProduto(produto);
	}
	
}
