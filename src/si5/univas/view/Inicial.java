package si5.univas.view;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import si5.univas.controller.Controller;
import si5.univas.model.GBC;

public class Inicial extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controller control;
	
	public Inicial(Controller control) {
		this.control = control;
	}

	ImageIcon icone = new ImageIcon(getClass().getResource("/imagens/cadastro.png"));
	Image i = icone.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	ImageIcon icone2 = new ImageIcon(getClass().getResource("/imagens/search.png"));
	Image i2 = icone2.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	ImageIcon icone3 = new ImageIcon(getClass().getResource("/imagens/sair.png"));
	Image i3 = icone3.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	ImageIcon icone4 = new ImageIcon(getClass().getResource("/imagens/pedido.png"));
	Image i4 = icone4.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	ImageIcon icone5 = new ImageIcon(getClass().getResource("/imagens/setas.png"));
	Image i5 = icone5.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	private JPanel pnGridbag = new JPanel();
	private JButton buttonCadastros = new JButton("Cadastros",new ImageIcon(i));
	private JButton buttonConsultas = new JButton("Consultas",new ImageIcon(i2));
	private JButton buttonPedido = new JButton("Gerar pedidos",new ImageIcon(i4));
	private JButton buttonEntradaEstoque = new JButton("Entrada e saida estoque",new ImageIcon(i5));
	private JButton buttonSair = new JButton("Sair",new ImageIcon(i3));
	
	
	public void tela(){
		buttonSair();
		buttonCliente();
		buttonConsultas();
		setContentPane(pnGridbag);
		pnGridbag.setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(400,400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Tela inicial");
		setResizable(false);
		pack();
		
		GBC gbc1 = new GBC(1,1).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc2 = new GBC(1,2).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc3 = new GBC(1,3).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc4 = new GBC(1,4).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc5 = new GBC(1,5).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		pnGridbag.add(buttonCadastros,gbc1);
		pnGridbag.add(buttonConsultas,gbc2);
		pnGridbag.add(buttonPedido,gbc3);
		pnGridbag.add(buttonEntradaEstoque,gbc4);
		pnGridbag.add(buttonSair,gbc5);	
		setVisible(true);
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
		buttonCadastros.addActionListener(cliente);
	}
	
	public void cliente(){
		control.cadastros();
	}
	
	public void buttonConsultas(){
		
		ActionListener produto = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				consultas();
			}
		};
		buttonConsultas.addActionListener(produto);
		
	}
	
	public void consultas(){
		control.consultas();
	}
	
}
