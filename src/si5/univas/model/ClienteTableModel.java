package si5.univas.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import si5.univas.entity.Cliente;

public class ClienteTableModel extends DefaultTableModel {

	private List<Cliente> internalList;
	private String[] header = new String[] {"Código","Nome","Email"};

	public ClienteTableModel(List<Cliente> newList) {
		this.internalList = newList;
	}
	
	@Override
	public int getRowCount() {
		if (internalList == null) {
			return 0;
		}
		return internalList.size(); // quantidade de objetos/linhas na tabela
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public String getColumnName(int column) {
		return header[column];
	}

	@Override
	public Object getValueAt(int row, int column) {
		Cliente cliente = internalList.get(row);
		if (column == 0) {
			return cliente.getCod();
		} else if (column == 1) {
			return cliente.getNome();
		} else if(column == 2) {
			return cliente.getEmail();
		}
		return cliente;
	}
	
}
