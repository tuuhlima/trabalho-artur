package si5.univas.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import si5.univas.controller.Controller;
import si5.univas.model.GBC;

public class TelaCadastroProduto extends JFrame {
	
	private JPanel pnGridBag = new JPanel();
	private JPanel pnBorder = new JPanel();
	private JPanel pnFlow = new JPanel();
	private JPanel pnButton = new JPanel();
	private Controller control;
	
	public TelaCadastroProduto(Controller control) {
		this.control = control;
	}
	
	private JLabel lbPesquisar = new JLabel("Pesquisar:");
	private JLabel lbNomeProduto = new JLabel("Nome produto:");
	private JLabel lbQtdProduto = new JLabel("Quantidade produto:");
	
	private JTextField txPesquisar = new JTextField(10);
	private JTextField txNomeProduto = new JTextField(10);
	private JTextField txQtdProduto = new JTextField(10);
	
	private JButton btPesquisar = new JButton("Buscar produto");
	private JButton btCadastro = new JButton("Cadastrar");
	private JButton btVoltar = new JButton("Voltar");
	
	public void tela(){
		buttonVoltar();
		pnGridBag.setLayout(new GridBagLayout());
		pnFlow.setLayout(new GridBagLayout());
		pnButton.setLayout(new GridBagLayout());
		pnBorder.setLayout(new BorderLayout());
		setContentPane(pnBorder);
		pnBorder.add(pnGridBag,BorderLayout.CENTER);
		pnBorder.add(pnButton,BorderLayout.SOUTH);
		pnBorder.add(pnFlow,BorderLayout.NORTH);
		setPreferredSize(new Dimension(400,300));
		setTitle("Cadastro e pesquisa de produtos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		pack();
		
		GBC lbPesquisa = new GBC(1,0).setSpan(1,1).setInsets(5,5,5,5).setIpad(7,7);
		GBC lbNome = new GBC(1,1).setSpan(1,1).setInsets(5,5,5,5).setIpad(7,7);
		GBC lbQtd = new GBC(1,2).setSpan(1,1).setInsets(5,5,5,5).setIpad(7,7);

		GBC txPesquisa = new GBC(2,0).setSpan(1,1).setInsets(5,5,5,5).setIpad(7,7);
		GBC txNome = new GBC(2,1).setSpan(1,1).setInsets(5,5,5,5).setIpad(7,7);
		GBC txQtd = new GBC(2,2).setSpan(1,1).setInsets(5,5,5,5).setIpad(7,7);

		GBC btvoltar = new GBC(1,8).setInsets(5,5,5,5).setIpad(7,7);
		GBC btcadastrar = new GBC(2,8).setInsets(5,5,5,5).setIpad(7,7);
		GBC btBuscar = new GBC(1,1).setInsets(3,3,3,3).setIpad(4,4).setSpan(2,1);
		
		pnFlow.add(lbPesquisar,lbPesquisa);
		pnFlow.add(txPesquisar, txPesquisa);
		
		pnGridBag.add(lbNomeProduto,lbNome);
		pnGridBag.add(txNomeProduto, txNome);
		
		pnGridBag.add(lbQtdProduto,lbQtd);
		pnGridBag.add(txQtdProduto, txQtd);
		
		pnFlow.add(btPesquisar, btBuscar);
		pnButton.add(btCadastro, btcadastrar);
		pnButton.add(btVoltar, btvoltar);	
	}
	
	public void buttonVoltar(){
		
		ActionListener voltar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				voltarCadastro();
			}
		};
		btVoltar.addActionListener(voltar);
	}
	
	public void voltarCadastro(){
		control.voltarCadastro();
	}
	
}
