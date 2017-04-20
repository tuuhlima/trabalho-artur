package si5.univas.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import si5.univas.controller.Controller;
import si5.univas.model.GBC;

public class Cadastros extends JFrame {

	private Controller control;
	
	private JPanel pnGridbag = new JPanel();
	private JPanel pnBorder = new JPanel();
	private JPanel pnButton = new JPanel();
	
	ImageIcon icone = new ImageIcon(getClass().getResource("/imagens/back.png"));
	Image back = icone.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	ImageIcon icone2 = new ImageIcon(getClass().getResource("/imagens/sair.png"));
	Image i2 = icone2.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	ImageIcon icone3 = new ImageIcon(getClass().getResource("/imagens/client.png"));
	Image i3 = icone3.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	ImageIcon icone4 = new ImageIcon(getClass().getResource("/imagens/box.png"));
	Image i4 = icone4.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	private JButton buttonCadastroCliente = new JButton("Cadastrar clientes",new ImageIcon(i3));
	private JButton buttonCadastroProduto = new JButton("Cadastrar produtos",new ImageIcon(i4));
	private JButton buttonVoltar = new JButton("Voltar",new ImageIcon(back));
	private JButton buttonSair = new JButton("Sair",new ImageIcon(i2));
	
	
	public Cadastros(Controller control) {
		this.control = control; 
	}
	
	public void tela(){
		buttonCadastroCliente();
		buttonCadastroProdutos();
		buttonVoltar();
		buttonSair();
		pnBorder.setLayout(new BorderLayout());
		pnGridbag.setLayout(new GridBagLayout());
		pnButton.setLayout(new GridBagLayout());
		setContentPane(pnBorder);
		pnBorder.add(pnButton,BorderLayout.SOUTH);
		pnBorder.add(pnGridbag,BorderLayout.CENTER);
		setPreferredSize(new Dimension(400,350));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Tela de cadastros");
		setResizable(false);
		pack();
		
		GBC gbc1 = new GBC(1,1).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc2 = new GBC(1,2).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc3 = new GBC(1,8).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc4 = new GBC(2,8).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		
		pnGridbag.add(buttonCadastroCliente,gbc1);
		pnGridbag.add(buttonCadastroProduto,gbc2);
		
		pnButton.add(buttonVoltar,gbc3);
		pnButton.add(buttonSair,gbc4);
		setLocationRelativeTo(null);
	}
	
	public void buttonCadastroCliente(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cadastroCliente();
			}
		};
		buttonCadastroCliente.addActionListener(listener);
	}
	
	public void cadastroCliente(){
		control.cliente();
	}
	
	public void buttonCadastroProdutos(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				produtos();
			}
		};
		buttonCadastroProduto.addActionListener(listener);
	}
	
	public void produtos(){
		control.produto();
	}
	
	public void buttonVoltar(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				voltar();
			}
		};
		buttonVoltar.addActionListener(listener);
	}
	
	public void voltar(){
		control.voltarInicial();
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
	
}
