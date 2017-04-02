package si5.univas.view;

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
	private Controller control;
	
	public TelaCadastroProduto(Controller control) {
		this.control = control;
	}
	
	private JLabel lbNomeProduto = new JLabel("Nome produto:");
	private JLabel lbQtdProduto = new JLabel("Quantidade produto:");
	
	private JTextField txNomeProduto = new JTextField(10);
	private JTextField txQtdProduto = new JTextField(10);
	
	private JButton btCadastro = new JButton("Cadastrar");
	private JButton btVoltar = new JButton("Voltar");
	
	public void tela(){
		buttonVoltar();
		pnGridBag.setLayout(new GridBagLayout());
		setContentPane(pnGridBag);
		setPreferredSize(new Dimension(400,200));
		setTitle("Cadastrar Produtos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		pack();
		
		GBC lbNome = new GBC(1,1).setSpan(1,1);
		GBC lbQtd = new GBC(1,2).setSpan(1,1);

		
		GBC txNome = new GBC(2,1).setSpan(1,1);
		GBC txQtd = new GBC(2,2).setSpan(1,1);

		GBC btvoltar = new GBC(1,3).setInsets(5,8,8,8);
		GBC btcadastrar = new GBC(2,3).setInsets(5,8,8,8);
		
		pnGridBag.add(lbNomeProduto,lbNome);
		pnGridBag.add(txNomeProduto, txNome);
		
		pnGridBag.add(lbQtdProduto,lbQtd);
		pnGridBag.add(txQtdProduto, txQtd);
				
		pnGridBag.add(btCadastro, btcadastrar);
		pnGridBag.add(btVoltar, btvoltar);	
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
