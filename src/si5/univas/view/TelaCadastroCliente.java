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

import si5.univas.model.GBC;
import si5.univas.controller.*;

public class TelaCadastroCliente extends JFrame {

	private JPanel pnGridBag = new JPanel();
	private JPanel pnBorder = new JPanel();
	private JPanel pnFlow = new JPanel();
	private JPanel pnButton = new JPanel();
	private Controller control;
	
	public TelaCadastroCliente(Controller control) {
		this.control = control;
	}
	
	private JLabel lbNomeCliente = new JLabel("Nome cliente:");
	private JLabel lbEmailCliente = new JLabel("Email cliente:");
	private JLabel lbPesquisarCliente = new JLabel("Pesquisar:");
	
	private JTextField txNomeCliente = new JTextField(10);
	private JTextField txEmailCliente = new JTextField(10);
	private JTextField txPesquisarCliente = new JTextField(10);
	
	private JButton btCadastro = new JButton("Cadastrar");
	private JButton btVoltar = new JButton("Voltar");
	private JButton btPesquisa = new JButton("Buscar cliente");
	
	public void tela(){
		buttonVoltar();
		pnBorder.setLayout(new BorderLayout());
		pnGridBag.setLayout(new GridBagLayout());
		pnFlow.setLayout(new GridBagLayout());
		pnButton.setLayout(new GridBagLayout());
		setContentPane(pnBorder);
		pnBorder.add(pnGridBag,BorderLayout.CENTER);
		pnBorder.add(pnFlow,BorderLayout.NORTH);
		pnBorder.add(pnButton,BorderLayout.SOUTH);
		setPreferredSize(new Dimension(400,300));
		setTitle("Cadastro e pesquisa de clientes");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		pack();
		
		GBC lbNome = new GBC(1,1).setSpan(1,1).setIpad(7,7).setInsets(5,5,5,5);
		GBC lbEmail = new GBC(1,2).setSpan(1,1).setIpad(7,7).setInsets(5,5,5,5);
		GBC lbPesquisar = new GBC(1,0).setSpan(1,1).setIpad(7,7).setInsets(5,5,5,5);
		
		GBC txNome = new GBC(2,1).setSpan(1,1).setIpad(7,7).setInsets(5,5,5,5);
		GBC txEmail = new GBC(2,2).setSpan(1,1).setIpad(7,7).setInsets(5,5,5,5);
		GBC txPesquisar = new GBC(2,0).setSpan(1,1).setIpad(7,7).setInsets(5,5,5,5);

		GBC btvoltar = new GBC(1,8).setIpad(10,10);
		GBC btcadastrar = new GBC(2,8).setIpad(10,10);
		GBC btPesquisar = new GBC(1,1).setInsets(3,3,3,3).setIpad(4,4).setSpan(2,1);
		
		pnGridBag.add(lbNomeCliente,lbNome);
		pnGridBag.add(txNomeCliente, txNome);
		
		pnGridBag.add(lbEmailCliente,lbEmail);
		pnGridBag.add(txEmailCliente, txEmail);
		
		pnButton.add(btVoltar, btvoltar);
		pnButton.add(btCadastro, btcadastrar);
		
		
		pnFlow.add(lbPesquisarCliente,lbPesquisar);
		pnFlow.add(txPesquisarCliente,txPesquisar);
		pnFlow.add(btPesquisa,btPesquisar);
			
	}
	
	public void buttonVoltar(){
		
		ActionListener voltar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				voltar();
			}
		};
		btVoltar.addActionListener(voltar);
	}
	
	public void voltar(){
		control.voltarCadastro();
	}
	
}
