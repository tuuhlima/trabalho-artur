package si5.univas.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import si5.univas.controller.Controller;
import si5.univas.model.GBC;

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
	
	private JLabel lbCliente = new JLabel("Cliente:");
	private JLabel lbProduto = new JLabel("Produto:");
	private JLabel lbQuantidade = new JLabel("Quantidade");
	
	private JTextField txCliente = new JTextField(10);
	private JTextField txProduto = new JTextField(10);
	private JTextField txQuantidade = new JTextField(5);
	
	private JButton buttonAdd = new JButton("+");
	private JButton buttonVoltar = new JButton("Voltar",new ImageIcon(back));
	private JButton buttonFinalizar = new JButton("Finalizar",new ImageIcon(check));
	
	
	public TelaCadastroPedido(Controller control) {
		this.control = control;
	}
	
	public void tela(){
		buttonAdd();
		buttonVoltar();
		buttonFinalizar();
		pnCentro.setLayout(new GridBagLayout());
		pnCima.setLayout(new GridBagLayout());
		pnBaixo.setLayout(new GridBagLayout());
		pnPrincipal.setLayout(new BorderLayout());
		setContentPane(pnPrincipal);
		pnPrincipal.add(pnCentro,BorderLayout.CENTER);
		pnPrincipal.add(pnCima, BorderLayout.NORTH);
		pnPrincipal.add(pnBaixo, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(400,300));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Gerar Pedido");
		setResizable(false);
		pack();
		
		GBC lbClienteGBC = new GBC(1,1).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC lbProdutoGBC = new GBC(1,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC lbQuantidadeGBC = new GBC(3,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		
		GBC txClienteGBC = new GBC(2,1).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC txProdutoGBC = new GBC(2,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC txQuantidadeGBC = new GBC(4,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		
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
		
		pnBaixo.add(buttonVoltar,buttonVoltarGBC);
		pnBaixo.add(buttonFinalizar, buttonFinalizarGBC);
		
		setLocationRelativeTo(null);
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
		if(txCliente.getText().isEmpty() || txProduto.getText().isEmpty() || txQuantidade.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Preencha os campos", "Erro",JOptionPane.ERROR_MESSAGE);
		}else{
			
		}
	}
	
	public void buttonFinalizar(){
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				finalizar();
			}
		};
		buttonFinalizar.addActionListener(listener);
	}
	
	public void finalizar(){
		if(txCliente.getText().isEmpty() || txProduto.getText().isEmpty() || txQuantidade.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Preencha os campos", "Erro",JOptionPane.ERROR_MESSAGE);
		}else{
			
		}
	}
	
}
