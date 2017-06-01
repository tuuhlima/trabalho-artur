package si5.univas.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import si5.univas.entity.Item;

public class ItemTableModel extends DefaultTableModel {

	private ArrayList<Item> internalList;
	private String[] header = new String[] {"Código","Cod_Pedido","Cod_Produto","Qtd"};

	public ItemTableModel(ArrayList<Item> newList) {
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
		Item item = internalList.get(row);
		if (column == 0) {
			return item.getCod();
		} else if (column == 1) {
			return item.getCod_pedido();
		} else if(column == 2) {
			return item.getCod_produto();
		} else if(column ==3){
			return item.getQtd();
		}
		return item;
	}
	
}
