package si5.univas.controller;

import javax.swing.JOptionPane;

import org.omg.PortableServer.ServantRetentionPolicyValue;

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
	
	
}
