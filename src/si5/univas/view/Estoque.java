package si5.univas.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import si5.univas.BI.ProdutoBI;
import si5.univas.BI.OrderException;
import si5.univas.controller.Controller;
import si5.univas.dao.DAOException;
import si5.univas.entity.Produto;
import si5.univas.model.GBC;
import si5.univas.model.ProdutoComboModel;

public class Estoque extends JFrame {
	
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
	
	private JLabel lbProduto = new JLabel("Produto:");
	private JLabel lbQuantidade = new JLabel("Quantidade:");
	
	private JComboBox  txProduto = new JComboBox();
	
	private JTextField txQuantidade = new JTextField(5);
	
	private JButton buttonAdd = new JButton("+");
	private JButton buttonVoltar = new JButton("Voltar",new ImageIcon(back));
	private JButton buttonFinalizar = new JButton("Finalizar",new ImageIcon(check));
	
	private ArrayList<Produto> listaProdutos = new ArrayList<>();
	
	private ProdutoComboModel produtoModel;
	
	public Estoque(Controller control) {
		this.control = control;
	}
	
	public void tela() throws ParseException, SQLException, DAOException{
		buttonAdd();
		buttonVoltar();
		comboBoxProduto();
		buttonFinalizar();
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
		if(txQuantidade.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Preencha os campos", "Erro",JOptionPane.ERROR_MESSAGE);
		}else{
			Produto produto = (Produto)produtoModel.getSelectedItem();
			String text1 = produto.getNome();
			String text2 = txQuantidade.getText();
			String[] row = new String[] { text1, text2 };
			getDataTableModel().addRow(row);
			clear();
			int i = Integer.parseInt(text2);
			produto.setQtd(produto.getQtd()+i);
			listaProdutos.add(produto);
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
		resposta = JOptionPane.showConfirmDialog(null,"Deseja realmente atualizar?");
		if(resposta == JOptionPane.YES_OPTION){
			ProdutoBI produtoBI = new ProdutoBI();
			produtoBI.atualizaSaldo(listaProdutos);
			JOptionPane.showMessageDialog(null,"Produtos atualizados com sucesso!");
			clear();
		}else{
			return;
		}
	}
	
	public void clear(){
		txQuantidade.setText("");
	}

	
}
