package si5.univas.model;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import si5.univas.entity.Cliente;

public class ClienteComboModel implements ComboBoxModel<Cliente>{

	private ArrayList<Cliente> clientes = new ArrayList<>();
	private Cliente clienteSelecionado = null;
	
	public ClienteComboModel(ArrayList<Cliente> cliente) {
		this.clientes = cliente;
	}
	
	@Override
	public void addListDataListener(ListDataListener arg0) {
		
	}

	@Override
	public Cliente getElementAt(int i) {
		return clientes.get(i);
	}

	@Override
	public int getSize() {
		return clientes.size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		
	}

	@Override
	public Object getSelectedItem() {
		return clienteSelecionado;
	}

	@Override
	public void setSelectedItem(Object cliente) {
		clienteSelecionado = (Cliente)cliente;
	}
	
	
}
