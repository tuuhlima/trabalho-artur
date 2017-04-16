package si5.univas.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

import si5.univas.model.Cliente;
import si5.univas.model.GBC;
import si5.univas.controller.*;
import si5.univas.dao.DAOException;

public class TelaCadastroCliente extends JFrame {

	private JPanel pnGridBag = new JPanel();
	private JPanel pnBorder = new JPanel();
	private JPanel pnFlow = new JPanel();
	private JPanel pnButton = new JPanel();
	private Controller control;
	
	ImageIcon icone = new ImageIcon(getClass().getResource("/imagens/back.png"));
	Image back = icone.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	ImageIcon icone2 = new ImageIcon(getClass().getResource("/imagens/check.png"));
	Image check = icone2.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
	
	public TelaCadastroCliente(Controller control) {
		this.control = control;
	}
	
	private JLabel lbNomeCliente = new JLabel("Nome cliente:");
	private JLabel lbEmailCliente = new JLabel("Email cliente:");
	
	private JTextField txNomeCliente = new JTextField(10);
	private JTextField txEmailCliente = new JTextField(10);
	
	private JButton btCadastro = new JButton("Cadastrar",new ImageIcon(check));
	private JButton btVoltar = new JButton("Voltar",new ImageIcon(back));
	
	public void tela(){
		buttonVoltar();
		buttonCadastrar();
		pnBorder.setLayout(new BorderLayout());
		pnGridBag.setLayout(new GridBagLayout());
		pnFlow.setLayout(new GridBagLayout());
		pnButton.setLayout(new GridBagLayout());
		setContentPane(pnBorder);
		pnBorder.add(pnGridBag,BorderLayout.CENTER);
		pnBorder.add(pnFlow,BorderLayout.NORTH);
		pnBorder.add(pnButton,BorderLayout.SOUTH);
		setPreferredSize(new Dimension(400,300));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Cadastro de clientes");
		setResizable(false);
		pack();
		
		GBC lbNome = new GBC(1,1).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC lbEmail = new GBC(1,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		
		GBC txNome = new GBC(2,1).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);
		GBC txEmail = new GBC(2,2).setSpan(1,1).setIpad(4,4).setInsets(5,5,5,5);

		GBC btvoltar = new GBC(1,8).setIpad(10,10);
		GBC btcadastrar = new GBC(2,8).setIpad(10,10);
		
		pnGridBag.add(lbNomeCliente,lbNome);
		pnGridBag.add(txNomeCliente, txNome);
		
		pnGridBag.add(lbEmailCliente,lbEmail);
		pnGridBag.add(txEmailCliente, txEmail);
		
		pnButton.add(btVoltar, btvoltar);
		pnButton.add(btCadastro, btcadastrar);
		setLocationRelativeTo(null);		
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
	
	public void buttonCadastrar(){
		
		ActionListener cadastro = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cadastroCliente();
				} catch (DAOException e1) {
					e1.printStackTrace();
				}
			}
		};
		btCadastro.addActionListener(cadastro);
	}
	
	public void cadastroCliente() throws DAOException{
			if(txNomeCliente.getText().isEmpty() || txEmailCliente.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"Preencha os campos", "Erro",JOptionPane.ERROR_MESSAGE);
			}else{
				join();
			}
		}
	
	public void join() throws DAOException{
		int resposta;
		resposta = JOptionPane.showConfirmDialog(null,"Deseja realmente cadastrar?");
		if(resposta == JOptionPane.YES_OPTION){
				Cliente cliente = new Cliente();
				cliente.setNome(txNomeCliente.getText());
				cliente.setEmail(txEmailCliente.getText());
				control.cadastroCliente(cliente);
				clearFields();
				JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
		}else{
			return;
		}
	}
	
	public void clearFields(){
		this.txNomeCliente.setText("");
		this.txEmailCliente.setText("");
	}
		
}
