package si5.univas.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
<<<<<<< HEAD
=======
import java.awt.FlowLayout;
>>>>>>> bf453fbb42870e6493fa631f1a9d4adbe1cf5968
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
=======

import javax.swing.ImageIcon;
import javax.swing.JButton;
>>>>>>> bf453fbb42870e6493fa631f1a9d4adbe1cf5968
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
<<<<<<< HEAD
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
import javax.swing.JTextField;

import si5.univas.controller.Controller;
import si5.univas.model.GBC;
>>>>>>> bf453fbb42870e6493fa631f1a9d4adbe1cf5968

public class TelaCadastroPedido extends JFrame {

	private Controller control;
	
	ImageIcon icone = new ImageIcon(getClass().getResource("/imagens/back.png"));
	Image back = icone.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	ImageIcon icone2 = new ImageIcon(getClass().getResource("/imagens/check.png"));
	Image check = icone2.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	private JPanel pnCentro = new JPanel();
	private JPanel pnCima = new JPanel();
	private JPanel pnBaixo = new JPanel();
	private JPanel pnPrincipal = new JPanel();
	
<<<<<<< HEAD
	private JTable dataTable;
	private DefaultTableModel dataTableModel;
	private JScrollPane dataScrollPane;
	
	private ClienteComboModel model;
	
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

	private JLabel lbCliente = new JLabel("Cliente:");
	private JLabel lbProduto = new JLabel("Produto:");
	private JLabel lbQuantidade = new JLabel("Quantidade:");
	private JLabel lbData = new JLabel("Data:");
	
	private JComboBox  txCliente = new JComboBox();
	private JComboBox  txProduto = new JComboBox();
	
	private JTextField txQuantidade = new JTextField(5);
	
	private JFormattedTextField txData = new JFormattedTextField(8);
	private MaskFormatter ftmData;
	
=======
	private JLabel lbCliente = new JLabel("Cliente:");
	private JLabel lbProduto = new JLabel("Produto:");
	private JLabel lbQuantidade = new JLabel("Quantidade");
	
	private JTextField txCliente = new JTextField(10);
	private JTextField txProduto = new JTextField(10);
	private JTextField txQuantidade = new JTextField(5);
	
>>>>>>> bf453fbb42870e6493fa631f1a9d4adbe1cf5968
	private JButton buttonAdd = new JButton("+");
	private JButton buttonVoltar = new JButton("Voltar",new ImageIcon(back));
	private JButton buttonFinalizar = new JButton("Finalizar",new ImageIcon(check));
	
<<<<<<< HEAD
	private ProdutoComboModel produtoModel;
=======
>>>>>>> bf453fbb42870e6493fa631f1a9d4adbe1cf5968
	
	public TelaCadastroPedido(Controller control) {
		this.control = control;
	}
	
<<<<<<< HEAD
	public void tela() throws ParseException, SQLException, DAOException{
		buttonAdd();
		buttonVoltar();
		buttonFinalizar();
		TextFieldComMascara();
		comboBoxCliente();
		comboBoxProduto();
=======
	public void tela(){
		buttonAdd();
		buttonVoltar();
		buttonFinalizar();
>>>>>>> bf453fbb42870e6493fa631f1a9d4adbe1cf5968
		pnCentro.setLayout(new GridBagLayout());
		pnCima.setLayout(new GridBagLayout());
		pnBaixo.setLayout(new GridBagLayout());
		pnPrincipal.setLayout(new BorderLayout());
		setContentPane(pnPrincipal);
		pnPrincipal.add(pnCentro,BorderLayout.CENTER);
		pnPrincipal.add(pnCima, BorderLayout.NORTH);
		pnPrincipal.add(pnBaixo, BorderLayout.SOUTH);
<<<<<<< HEAD
		setPreferredSize(new Dimension(500,500));
=======
		setPreferredSize(new Dimension(400,300));
>>>>>>> bf453fbb42870e6493fa631f1a9d4adbe1cf5968
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Gerar Pedido");
		setResizable(false);
		pack();
		
		GBC lbClienteGBC = new GBC(1,1).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC lbProdutoGBC = new GBC(1,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC lbQuantidadeGBC = new GBC(3,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
<<<<<<< HEAD
		GBC lbDataGBC = new GBC(3,1).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
=======
>>>>>>> bf453fbb42870e6493fa631f1a9d4adbe1cf5968
		
		GBC txClienteGBC = new GBC(2,1).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC txProdutoGBC = new GBC(2,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC txQuantidadeGBC = new GBC(4,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
<<<<<<< HEAD
		GBC txDataGBC = new GBC(4,1).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
=======
>>>>>>> bf453fbb42870e6493fa631f1a9d4adbe1cf5968
		
		GBC buttonAddGBC = new GBC(5,2);
		GBC buttonVoltarGBC = new GBC(1,1).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC buttonFinalizarGBC = new GBC(2,1).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		
		pnCima.add(lbCliente,lbClienteGBC);
		pnCima.add(txCliente, txClienteGBC);
		pnCima.add(lbProduto, lbProdutoGBC);
		pnCima.add(txProduto, txProdutoGBC);
		pnCima.add(lbQuantidade,lbQuantidadeGBC);
		pnCima.add(txQuantidade, txQuantidadeGBC);
		pnCima.add(buttonAdd,buttonAddGBC);
<<<<<<< HEAD
		pnCima.add(lbData, lbDataGBC);
		pnCima.add(txData, txDataGBC);
=======
>>>>>>> bf453fbb42870e6493fa631f1a9d4adbe1cf5968
		
		pnBaixo.add(buttonVoltar,buttonVoltarGBC);
		pnBaixo.add(buttonFinalizar, buttonFinalizarGBC);
		
<<<<<<< HEAD
		pnCentro.add(getDataScrollPane());
		
		setLocationRelativeTo(null);
	}
	
	public void comboBoxCliente() throws SQLException, DAOException{
		ArrayList<Cliente> clientes = new ArrayList<>();
		clientes = control.pesquisaCliente();
		txCliente.setModel(new ClienteComboModel(clientes));
	}
	
	public void comboBoxProduto() throws SQLException, DAOException{
		ArrayList<Produto> produtos = new ArrayList<>();
		produtos = control.pesquisaProduto();
		produtoModel = new ProdutoComboModel(produtos);
		txProduto.setModel(produtoModel);
	}
	
	public void TextFieldComMascara() throws ParseException{
		ftmData = new MaskFormatter("##/##/####");
		txData = new JFormattedTextField(ftmData);
		ftmData.setValidCharacters("0123456789");
	}
	
=======
		setLocationRelativeTo(null);
	}
	
>>>>>>> bf453fbb42870e6493fa631f1a9d4adbe1cf5968
	public void buttonVoltar(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				voltar();
			}
		};
		buttonVoltar.addActionListener(listener);
	}
	
	public void voltar(){
		control.voltaInicial();
	}
	
	public void buttonAdd(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				add();
			}
		};
		buttonAdd.addActionListener(listener);
	}
	
	public void add(){
<<<<<<< HEAD
		if(txQuantidade.getText().isEmpty()|| txData.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Preencha os campos", "Erro",JOptionPane.ERROR_MESSAGE);
		}else{
			//
			Produto produto = (Produto)produtoModel.getSelectedItem();
			String text1 = produto.getNome();
			String text2 = txQuantidade.getText();
			String[] row = new String[] { text1, text2 };
			getDataTableModel().addRow(row);
			clear();
=======
		if(txCliente.getText().isEmpty() || txProduto.getText().isEmpty() || txQuantidade.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Preencha os campos", "Erro",JOptionPane.ERROR_MESSAGE);
		}else{
			
>>>>>>> bf453fbb42870e6493fa631f1a9d4adbe1cf5968
		}
	}
	
	public void buttonFinalizar(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				try {
					finalizar();
				} catch (DAOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
=======
				finalizar();
>>>>>>> bf453fbb42870e6493fa631f1a9d4adbe1cf5968
			}
		};
		buttonFinalizar.addActionListener(listener);
	}
<<<<<<< HEAD
	
	public void finalizar() throws DAOException{
		if(txData.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Preencha os campos", "Erro",JOptionPane.ERROR_MESSAGE);
		}else{
			join();
		}
	}
	
	public void join() throws DAOException{
		int resposta;
		resposta = JOptionPane.showConfirmDialog(null,"Deseja realmente cadastrar?");
		if(resposta == JOptionPane.YES_OPTION){
				Pedido pedido = new Pedido();
				Cliente cliente = (Cliente) txCliente.getSelectedItem();
				pedido.setData(txData.getText());
				control.cadastrarPedido(cliente, pedido);
				JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
		}else{
			return;
=======
	
	public void finalizar(){
		if(txCliente.getText().isEmpty() || txProduto.getText().isEmpty() || txQuantidade.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Preencha os campos", "Erro",JOptionPane.ERROR_MESSAGE);
		}else{
			
>>>>>>> bf453fbb42870e6493fa631f1a9d4adbe1cf5968
		}
	}
	
	public void clear(){
		txQuantidade.setText("");
	}
}
