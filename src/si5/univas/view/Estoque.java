package si5.univas.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import si5.univas.controller.Controller;
import si5.univas.dao.DAOException;
import si5.univas.model.Cliente;
import si5.univas.model.ClienteComboModel;
import si5.univas.model.GBC;
import si5.univas.model.Pedido;
import si5.univas.model.Produto;
import si5.univas.model.ProdutoComboModel;
=======

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import si5.univas.controller.Controller;
import si5.univas.model.GBC;
>>>>>>> 55bbe1c30dc83b3cbf3a472192ba432870660376

public class Estoque extends JFrame {
	
	private Controller control;
	
<<<<<<< HEAD
	ImageIcon icone = new ImageIcon(getClass().getResource("/imagens/back.png"));
	Image back = icone.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	ImageIcon icone2 = new ImageIcon(getClass().getResource("/imagens/check.png"));
	Image check = icone2.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	private JPanel pnCentro = new JPanel();
	private JPanel pnCima = new JPanel();
	private JPanel pnBaixo = new JPanel();
	private JPanel pnPrincipal = new JPanel();
	
	private JTable dataTable;
	private DefaultTableModel dataTableModel;
	private JScrollPane dataScrollPane;
	
	private JLabel lbProduto = new JLabel("Produto:");
	private JLabel lbQuantidade = new JLabel("Quantidade:");
	
	private JComboBox  txProduto = new JComboBox();
	
	private JTextField txQuantidade = new JTextField(5);
	
	private JButton buttonAdd = new JButton("+");
	private JButton buttonVoltar = new JButton("Voltar",new ImageIcon(back));
	private JButton buttonFinalizar = new JButton("Finalizar",new ImageIcon(check));
	
	private ProdutoComboModel produtoModel;
	
	public Estoque(Controller control) {
		this.control = control;
	}
	
	public void tela() throws ParseException, SQLException, DAOException{
		buttonAdd();
		buttonVoltar();
		comboBoxProduto();
		pnCentro.setLayout(new GridBagLayout());
		pnCima.setLayout(new GridBagLayout());
		pnBaixo.setLayout(new GridBagLayout());
		pnPrincipal.setLayout(new BorderLayout());
		setContentPane(pnPrincipal);
		pnPrincipal.add(pnCentro,BorderLayout.CENTER);
		pnPrincipal.add(pnCima, BorderLayout.NORTH);
		pnPrincipal.add(pnBaixo, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(500,500));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Entrada de estoque");
		setResizable(false);
		pack();
		
		GBC lbProdutoGBC = new GBC(1,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC lbQuantidadeGBC = new GBC(3,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		
		GBC txProdutoGBC = new GBC(2,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC txQuantidadeGBC = new GBC(4,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		
		GBC buttonAddGBC = new GBC(5,2);
		GBC buttonVoltarGBC = new GBC(1,1).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC buttonFinalizarGBC = new GBC(2,1).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		
		pnCima.add(lbProduto, lbProdutoGBC);
		pnCima.add(txProduto, txProdutoGBC);
		pnCima.add(lbQuantidade,lbQuantidadeGBC);
		pnCima.add(txQuantidade, txQuantidadeGBC);
		pnCima.add(buttonAdd,buttonAddGBC);
		
		pnBaixo.add(buttonVoltar,buttonVoltarGBC);
		pnBaixo.add(buttonFinalizar, buttonFinalizarGBC);
		
		pnCentro.add(getDataScrollPane());
		
		setLocationRelativeTo(null);
	}
	
	public JTable getDataTable() {
		if (dataTable == null) {
			dataTable = new JTable();
			dataTable.setModel(getDataTableModel());
		}
		return dataTable;
	}

	public DefaultTableModel getDataTableModel() {
		if (dataTableModel == null) {
			dataTableModel = new DefaultTableModel();
			String[] identifiers = new String[] { "Produto", "Quantidade" };
			dataTableModel.setColumnIdentifiers(identifiers);
		}
		return dataTableModel;
	}

	public JScrollPane getDataScrollPane() {
		if (dataScrollPane == null) {
			dataScrollPane = new JScrollPane();
			dataScrollPane.setViewportView(getDataTable());
			dataScrollPane.setPreferredSize(new Dimension(400,200));
		}
		return dataScrollPane;
	}
		
	public void comboBoxProduto() throws SQLException, DAOException{
		ArrayList<Produto> produtos = new ArrayList<>();
		produtos = control.pesquisaProduto();
		produtoModel = new ProdutoComboModel(produtos);
		txProduto.setModel(produtoModel);
	}
	
=======
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
	
	
>>>>>>> 55bbe1c30dc83b3cbf3a472192ba432870660376
	public void buttonVoltar(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
<<<<<<< HEAD
			public void actionPerformed(ActionEvent e) {
=======
			public void actionPerformed(ActionEvent arg0) {
>>>>>>> 55bbe1c30dc83b3cbf3a472192ba432870660376
				voltar();
			}
		};
		buttonVoltar.addActionListener(listener);
	}
	
	public void voltar(){
		control.voltaInicial();
	}
	
<<<<<<< HEAD
	public void buttonAdd(){
=======
	public void buttonSair(){
>>>>>>> 55bbe1c30dc83b3cbf3a472192ba432870660376
		
		ActionListener listener = new ActionListener() {
			
			@Override
<<<<<<< HEAD
			public void actionPerformed(ActionEvent e) {
				add();
			}
		};
		buttonAdd.addActionListener(listener);
	}
	
	public void add(){
		if(txQuantidade.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Preencha os campos", "Erro",JOptionPane.ERROR_MESSAGE);
		}else{
			Produto produto = (Produto)produtoModel.getSelectedItem();
			String text1 = produto.getNome();
			String text2 = txQuantidade.getText();
			String[] row = new String[] { text1, text2 };
			getDataTableModel().addRow(row);
			clear();
		}
	}
		
	public void clear(){
		txQuantidade.setText("");
=======
			public void actionPerformed(ActionEvent arg0) {
				sair();
			}
		};
		buttonSair.addActionListener(listener);
	}
	
	public void sair(){
		control.exit();
>>>>>>> 55bbe1c30dc83b3cbf3a472192ba432870660376
	}
	
}
