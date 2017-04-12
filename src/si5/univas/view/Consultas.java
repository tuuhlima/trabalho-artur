package si5.univas.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import si5.univas.controller.Controller;
import si5.univas.model.GBC;

public class Consultas extends JFrame {
	
	private Controller control;
	
	public Consultas(Controller control) {
		this.control = control;
	}
	
	private JPanel pnBorder = new JPanel();
	private JPanel pnGridbag = new JPanel();
	private JPanel pnButton = new JPanel();
	
	private JButton buttonConsultaCliente = new JButton("Consultar clientes");
	private JButton buttonConsultaProduto = new JButton("Consultar produtos");
	private JButton buttonConsultaPedido = new JButton("Consultar pedidos");
	private JButton buttonVoltar = new JButton("Voltar");
	private JButton buttonSair = new JButton("Sair");
	
	public void tela(){
		buttonSair();
		buttonVoltar();
		pnBorder.setLayout(new BorderLayout());
		pnGridbag.setLayout(new GridBagLayout());
		pnButton.setLayout(new GridBagLayout());
		setContentPane(pnBorder);
		pnBorder.add(pnButton,BorderLayout.SOUTH);
		pnBorder.add(pnGridbag,BorderLayout.CENTER);
		setPreferredSize(new Dimension(400,350));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Tela de consultas");
		setResizable(false);
		pack();
		
		GBC gbc1 = new GBC(1,1).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc2 = new GBC(1,2).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc3 = new GBC(1,3).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc4 = new GBC(1,8).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc5 = new GBC(2,8).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		
		pnGridbag.add(buttonConsultaCliente,gbc1);
		pnGridbag.add(buttonConsultaProduto,gbc2);
		pnGridbag.add(buttonConsultaPedido, gbc3);
		
		pnButton.add(buttonVoltar,gbc4);
		pnButton.add(buttonSair,gbc5);
	}
	
	public void buttonSair(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sair();
			}
		};
		buttonSair.addActionListener(listener);
	}
	
	public void sair(){
		control.exit();
	}
	
	public void buttonVoltar(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				voltarInicial();
			}
		};
		buttonVoltar.addActionListener(listener);
	}
	
	public void voltarInicial(){
		control.voltarInicial();
	}
	
}
