package si5.univas.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import si5.univas.controller.Controller;
import si5.univas.dao.DAOException;
import si5.univas.model.Cliente;
import si5.univas.model.ClienteTableModel;


public class ConsultaClienteView extends JFrame{
	private Controller control;
	
	private JButton btvoltar = new JButton("Voltar");
	private JButton btSair = new JButton("Sair");
	
	private JPanel pnBase = new JPanel();
	private JPanel pnBorder = new JPanel();
	private JPanel pnFlow = new JPanel();
	
   public ConsultaClienteView(Controller control) {
		this.control = control;
	}
	
	public void init() throws SQLException, DAOException{
		tela();
		addButton();
		eventVoltar();
		eventSair();
		
	}
	
	public void tela() throws SQLException, DAOException{
		ClienteTableModel model = new ClienteTableModel(control.pesquisaCliente());
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		pnBase.add(scroll);
		pnBorder.setLayout(new BorderLayout());
		pnFlow.setLayout(new FlowLayout());
		setContentPane(pnBorder);
		pnBorder.add(pnBase,BorderLayout.CENTER);
		pnBorder.add(pnFlow, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(480,650));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Consulta - Cliente");
		setResizable(false);
		pack();
	}
	
	public void addButton(){
		pnFlow.add(btvoltar);
		pnFlow.add(btSair);
	}
	
	public void eventVoltar(){
		ActionListener voltar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				volta();
			}
		};
		btvoltar.addActionListener(voltar);
	}
	
	public void volta(){
	//	control.livroToUser();
	}
	
	public void eventSair(){
		ActionListener sair = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sair();
			}
		};
		btSair.addActionListener(sair);
	}
	
	public void sair(){
		control.exit();
	}
}
