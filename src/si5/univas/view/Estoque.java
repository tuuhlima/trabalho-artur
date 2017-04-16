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

public class Estoque extends JFrame {
	
	private Controller control;
	
	private JPanel pnGridbag = new JPanel();
	private JPanel pnBorder = new JPanel();
	private JPanel pnButton = new JPanel();
	
	ImageIcon icone = new ImageIcon(getClass().getResource("/imagens/back.png"));
	Image back = icone.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	ImageIcon icone2 = new ImageIcon(getClass().getResource("/imagens/sair.png"));
	Image i2 = icone2.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	ImageIcon icone3 = new ImageIcon(getClass().getResource("/imagens/plus2.png"));
	Image i3 = icone3.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	ImageIcon icone4 = new ImageIcon(getClass().getResource("/imagens/baixo.png"));
	Image i4 = icone4.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
		
	private JButton buttonEntradaEstoque = new JButton("Entrada de Estoque",new ImageIcon(i3));
	private JButton buttonSaidaEstoque = new JButton("Saida de Estoque",new ImageIcon(i4));
	private JButton buttonVoltar = new JButton("Voltar",new ImageIcon(back));
	private JButton buttonSair = new JButton("Sair",new ImageIcon(i2));
	
	
	public Estoque(Controller control) {
		this.control = control; 
	}
	
	public void tela(){
		buttonEntradaEstoque();
		buttonSaidaEstoque();
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
		setTitle("Estoques");
		setResizable(false);
		pack();
		
		GBC gbc1 = new GBC(1,1).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc2 = new GBC(1,2).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc3 = new GBC(1,8).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		GBC gbc4 = new GBC(2,8).setSpan(1,1).setIpad(10,10).setInsets(8,8,8,8);
		
		pnGridbag.add(buttonEntradaEstoque,gbc1);
		pnGridbag.add(buttonSaidaEstoque,gbc2);
		
		pnButton.add(buttonVoltar,gbc3);
		pnButton.add(buttonSair,gbc4);
		setLocationRelativeTo(null);
	}
	
	public void buttonEntradaEstoque(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		};
		buttonEntradaEstoque.addActionListener(listener);
	}

	public void buttonSaidaEstoque(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		};
		buttonSaidaEstoque.addActionListener(listener);
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
		control.voltaInicial();
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
