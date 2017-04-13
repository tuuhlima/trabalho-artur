package si5.univas.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import si5.univas.dao.ConnectionFactory;
import si5.univas.dao.ClienteDAO;
import si5.univas.dao.DAOException;
import si5.univas.dao.ProdutoDAO;
import si5.univas.model.Cliente;
import si5.univas.model.Produto;
import si5.univas.view.Cadastros;
import si5.univas.view.ConsultaClienteView;
import si5.univas.view.Consultas;
import si5.univas.view.Inicial;
import si5.univas.view.TelaCadastroCliente;
import si5.univas.view.TelaCadastroProduto;

public class Controller {
	
	Inicial inicial = new Inicial(this);
	TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente(this);
	TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto(this);
	Cadastros cadastros = new Cadastros(this);
	Consultas consultas = new Consultas(this);
	ConsultaClienteView consultaCliente = new ConsultaClienteView (this);
	
	public void iniciar() throws SQLException, DAOException{
		inicial.tela();
		
		telaCadastroCliente.tela();
		telaCadastroCliente.setVisible(false);
		
		telaCadastroProduto.tela();
		telaCadastroProduto.setVisible(false);
		
		cadastros.tela();
		cadastros.setVisible(false);
		
		consultas.tela();
		consultas.setVisible(false);
	
		consultaCliente.tela();
		consultaCliente.setVisible(false);
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
		cadastros.setVisible(false);
		telaCadastroCliente.setVisible(true);
	}
	
	public void voltarCadastro(){
		telaCadastroCliente.setVisible(false);
		telaCadastroProduto.setVisible(false);
		cadastros.setVisible(true);
	}
	
	public void produto(){
		cadastros.setVisible(false);
		telaCadastroProduto.setVisible(true);
	}
	
	public void voltarInicial(){
		cadastros.setVisible(false);
		consultas.setVisible(false);
		inicial.setVisible(true);
	}
	
	public void cadastros(){
		cadastros.setVisible(true);
		inicial.setVisible(false);
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
	
	public void consultas(){
		inicial.setVisible(false);
		consultas.setVisible(true);
	}
	
	public void consultaCliente(){
		consultas.setVisible(false);
		consultaCliente.setVisible(true);
	}
	
	
	
	public ArrayList<Cliente> pesquisaCliente() throws SQLException, DAOException{
		ClienteDAO cliente = new ClienteDAO();
		return cliente.pesquisarClientes();
		
	}
	
}
