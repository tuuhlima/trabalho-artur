package si5.univas.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import si5.univas.BI.OrderException;
import si5.univas.BI.PedidoBI;
import si5.univas.controller.Controller;
import si5.univas.dao.DAOException;
import si5.univas.entity.Cliente;
import si5.univas.entity.Item;
import si5.univas.entity.Pedido;
import si5.univas.entity.Produto;
import si5.univas.model.ClienteComboModel;
import si5.univas.model.GBC;
import si5.univas.model.ProdutoComboModel;

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
	
	private JTable dataTable;
	private DefaultTableModel dataTableModel;
	private JScrollPane dataScrollPane;
	
	private ClienteComboModel model;

	private JLabel lbCliente = new JLabel("Cliente:");
	private JLabel lbProduto = new JLabel("Produto:");
	private JLabel lbQuantidade = new JLabel("Quantidade:");
	private JLabel lbData = new JLabel("Data:");
	
	private JComboBox  txCliente = new JComboBox();
	private JComboBox  txProduto = new JComboBox();
	
	private JTextField txQuantidade = new JTextField(5);
	
	private JFormattedTextField txData = new JFormattedTextField(10);
	private MaskFormatter ftmData;
	
	private JButton buttonAdd = new JButton("+");
	private JButton buttonVoltar = new JButton("Voltar",new ImageIcon(back));
	private JButton buttonFinalizar = new JButton("Finalizar",new ImageIcon(check));
	
	private ProdutoComboModel produtoModel;
	
	private ArrayList<Item> itens = new ArrayList<>();
	
	public TelaCadastroPedido(Controller control) {
		this.control = control;
	}
	
	public void tela() throws ParseException, SQLException, DAOException{
		buttonAdd();
		buttonVoltar();
		buttonFinalizar();
		TextFieldComMascara();
		comboBoxCliente();
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
		setTitle("Gerar Pedido");
		setResizable(false);
		pack();
		
		GBC lbClienteGBC = new GBC(1,1).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC lbProdutoGBC = new GBC(1,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC lbQuantidadeGBC = new GBC(3,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC lbDataGBC = new GBC(3,1).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		
		GBC txClienteGBC = new GBC(2,1).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC txProdutoGBC = new GBC(2,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC txQuantidadeGBC = new GBC(4,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC txDataGBC = new GBC(4,1).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		
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
		pnCima.add(lbData, lbDataGBC);
		pnCima.add(txData, txDataGBC);
		
		pnBaixo.add(buttonVoltar,buttonVoltarGBC);
		pnBaixo.add(buttonFinalizar, buttonFinalizarGBC);
		
		pnCentro.add(getDataScrollPane());
		
		setLocationRelativeTo(null);
		
		Date now = new Date();
		String formatDate = new SimpleDateFormat("dd/MM/yyyy").format(now);
		txData.setText(formatDate);
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
	
	public void comboBoxCliente() throws SQLException, DAOException{
		List<Cliente> clientes = control.pesquisaCliente();
		txCliente.setModel(new ClienteComboModel(clientes));
	}
	
	public void comboBoxProduto() throws SQLException, DAOException{
		List<Produto> produtos = new ArrayList<>();
		produtos = control.pesquisaProduto();
		produtoModel = new ProdutoComboModel(produtos);
		txProduto.setModel(produtoModel);
	}
	
	public void TextFieldComMascara() throws ParseException{
		ftmData = new MaskFormatter("##/##/####");
		txData = new JFormattedTextField(ftmData);
		ftmData.setValidCharacters("0123456789");
	}
	
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
		if(txQuantidade.getText().isEmpty()|| txData.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Preencha os campos", "Erro",JOptionPane.ERROR_MESSAGE);
		}else{		
			Item item = new Item();
			Produto produto = (Produto)produtoModel.getSelectedItem();
			String text1 = produto.getNome();
			String text2 = txQuantidade.getText();
			String[] row = new String[] { text1, text2 };
			getDataTableModel().addRow(row);
			clear();
			item.setProduto(produtoModel.getSelectedItem());
			int i = Integer.parseInt(text2);
			item.setQuantidade(i);
			itens.add(item);
		}
		
	}
	
	public void buttonFinalizar(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					finalizar();
				} catch (DAOException e1) {
					e1.printStackTrace();
				} catch (OrderException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		};
		buttonFinalizar.addActionListener(listener);
	}
	
	public void finalizar() throws DAOException, OrderException, ParseException{
			join();
	}
	
	public void join() throws DAOException, OrderException, ParseException{
		int resposta;
		resposta = JOptionPane.showConfirmDialog(null,"Deseja realmente cadastrar?");
		if(resposta == JOptionPane.YES_OPTION){
				Pedido pedido = new Pedido();
				Cliente cliente = (Cliente) txCliente.getSelectedItem();
				PedidoBI pedidoBI = new PedidoBI();
				String dateAsString = txData.getText();
				pedido.setData(new SimpleDateFormat("dd/MM/yyyy").parse(dateAsString));
				pedidoBI.createOrder(cliente,itens,pedido);
				JOptionPane.showMessageDialog(null,"Pedido realizado com sucesso!");
		}else{
			return;
		}
	}
	
	public void clear(){
		txQuantidade.setText("");
	}
}
