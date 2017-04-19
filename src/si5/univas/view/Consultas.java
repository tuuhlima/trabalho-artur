package si5.univas.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import si5.univas.controller.Controller;
import si5.univas.dao.DAOException;
import si5.univas.model.GBC;

public class Consultas extends JFrame {
	
	private Controller control;
	
	public Consultas(Controller control) {
		this.control = control;
	}
	
	ImageIcon icone3 = new ImageIcon(getClass().getResource("/imagens/sair.png"));
	Image i3 = icone3.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	ImageIcon icone2 = new ImageIcon(getClass().getResource("/imagens/pesquisacliente.png"));
	Image pesquisaCliente = icone2.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	ImageIcon icone = new ImageIcon(getClass().getResource("/imagens/back.png"));
	Image back = icone.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	ImageIcon icone4 = new ImageIcon(getClass().getResource("/imagens/pesquisaproduto.png"));
	Image pesquisaProduto = icone4.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	ImageIcon icone5 = new ImageIcon(getClass().getResource("/imagens/pesquisapedido.png"));
	Image pesquisaPedido = icone5.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	private JPanel pnBorder = new JPanel();
	private JPanel pnGridbag = new JPanel();
	private JPanel pnButton = new JPanel();
	
	private JButton buttonConsultaCliente = new JButton("Consultar clientes",new ImageIcon(pesquisaCliente));
	private JButton buttonConsultaProduto = new JButton("Consultar produtos",new ImageIcon(pesquisaProduto));
	private JButton buttonConsultaPedido = new JButton("Consultar pedidos",new ImageIcon(pesquisaPedido));
	private JButton buttonVoltar = new JButton("Voltar",new ImageIcon(back));
	private JButton buttonSair = new JButton("Sair",new ImageIcon(i3));
	
	public void tela(){
		buttonSair();
		buttonVoltar();
		buttonPesquisaCliente();
		buttonPesquisaProduto();
		pnBorder.setLayout(new BorderLayout());
		pnGridbag.setLayout(new GridBagLayout());
		pnButton.setLayout(new GridBagLayout());
		setContentPane(pnBorder);
		pnBorder.add(pnButton,BorderLayout.SOUTH);
		pnBorder.add(pnGridbag,BorderLayout.CENTER);
		setPreferredSize(new Dimension(400,350));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		setLocationRelativeTo(null);
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
	
	public void buttonPesquisaCliente(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					pesquisaCliente();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (DAOException e) {
					e.printStackTrace();
				}
			}
		};
		buttonConsultaCliente.addActionListener(listener);
	}
	
	public void pesquisaCliente() throws SQLException, DAOException{
		control.consultaCliente();
		control.pesquisaCliente();
	}
	
	public void buttonPesquisaProduto(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					pesquisaProduto();
				} catch (SQLException | DAOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		buttonConsultaProduto.addActionListener(listener);
	}
	
	public void pesquisaProduto() throws SQLException, DAOException{
		control.consultaProduto();
		control.pesquisaProduto();
	}
	
	
}
