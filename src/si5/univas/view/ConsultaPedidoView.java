package si5.univas.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import si5.univas.controller.Controller;
import si5.univas.dao.DAOException;
import si5.univas.model.ItemTableModel;

public class ConsultaPedidoView extends JFrame{

	private Controller control;
	
	private JPanel pnBase = new JPanel();
	private JPanel pnBorder = new JPanel();
	
   public ConsultaPedidoView(Controller control) {
		this.control = control;
	}
	
	public void init() throws SQLException, DAOException{
		tela();
	}
	
	public void tela() throws SQLException, DAOException{
		ItemTableModel model = new ItemTableModel(control.pesquisaItem());
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		pnBase.add(scroll);
		pnBorder.setLayout(new BorderLayout());
		setContentPane(pnBorder);
		pnBorder.add(pnBase,BorderLayout.CENTER);
		setPreferredSize(new Dimension(480,500));
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Consulta - Pedidos");
		setResizable(false);
		pack();
	}
	
}
