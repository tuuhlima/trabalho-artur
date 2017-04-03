package si5.univas.view;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import si5.univas.controller.Controller;
import si5.univas.model.GBC;

public class TelaCadastro extends JFrame {
	
	private Controller control;
	
	public TelaCadastro(Controller control) {
		this.control = control;
	}

	private JPanel pnGridbag = new JPanel();
	private JButton buttonCadastroCliente = new JButton("Cadastro e Pesquisa Clientes");
	private JButton buttonCadastroProduto = new JButton("Cadastro e Pesquisa Produtos");
	private JButton buttonCadastroPedido = new JButton("Cadastro e Pesquisa Pedidos");
	private JButton buttonEntradaEstoque = new JButton("Entrada e Pesquisa Estoque");
	private JButton buttonSair = new JButton("Sair");
	
	
	public void tela(){
		buttonSair();
		buttonCliente();
		buttonProduto();
		setContentPane(pnGridbag);
		pnGridbag.setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(400,350));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Cadastro e Pesquisa");
		setResizable(false);
		pack();
		setVisible(true);
		
		GBC gbc1 = new GBC(1,1).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc2 = new GBC(1,2).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc3 = new GBC(1,3).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc4 = new GBC(1,4).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc5 = new GBC(1,5).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		pnGridbag.add(buttonCadastroCliente,gbc1);
		pnGridbag.add(buttonCadastroProduto,gbc2);
		pnGridbag.add(buttonCadastroPedido,gbc3);
		pnGridbag.add(buttonEntradaEstoque,gbc4);
		pnGridbag.add(buttonSair,gbc5);
	}
	
	public void buttonSair(){
		
		ActionListener sair = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sair();
			}
		};
		buttonSair.addActionListener(sair);
	}
	
	public void sair(){
		control.exit();
	}
	
	public void buttonCliente(){
		
		ActionListener cliente = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cliente();
			}
		};
		buttonCadastroCliente.addActionListener(cliente);
	}
	
	public void cliente(){
		control.cliente();
	}
	
	public void buttonProduto(){
		
		ActionListener produto = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				produto();
			}
		};
		buttonCadastroProduto.addActionListener(produto);
		
	}
	
	public void produto(){
		control.produto();
	}
	
}
