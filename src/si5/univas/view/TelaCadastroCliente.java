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

import si5.univas.model.GBC;
import si5.univas.controller.*;

public class TelaCadastroCliente extends JFrame {

	private JPanel pnGridBag = new JPanel();
	private Controller control;
	
	public TelaCadastroCliente(Controller control) {
		this.control = control;
	}
	
	private JLabel lbNomeCliente = new JLabel("Nome cliente:");
	private JLabel lbEmailCliente = new JLabel("Email cliente:");
	
	private JTextField txNomeCliente = new JTextField(10);
	private JTextField txEmailCliente = new JTextField(10);
	
	private JButton btCadastro = new JButton("Cadastrar");
	private JButton btVoltar = new JButton("Voltar");
	
	public void tela(){
		buttonVoltar();
		pnGridBag.setLayout(new GridBagLayout());
		setContentPane(pnGridBag);
		setPreferredSize(new Dimension(400,200));
		setTitle("Cadastrar Clientes");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		pack();
		
		GBC lbNome = new GBC(1,1).setSpan(1,1);
		GBC lbEmail = new GBC(1,2).setSpan(1,1);

		
		GBC txNome = new GBC(2,1).setSpan(1,1);
		GBC txEmail = new GBC(2,2).setSpan(1,1);

		GBC btvoltar = new GBC(1,3);
		GBC btcadastrar = new GBC(2,3);
		
		pnGridBag.add(lbNomeCliente,lbNome);
		pnGridBag.add(txNomeCliente, txNome);
		
		pnGridBag.add(lbEmailCliente,lbEmail);
		pnGridBag.add(txEmailCliente, txEmail);
				
		pnGridBag.add(btCadastro, btcadastrar);
		pnGridBag.add(btVoltar, btvoltar);
			
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
