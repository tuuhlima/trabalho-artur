package si5.univas.model;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import si5.univas.entity.Item;

public class ItemTableModel extends DefaultTableModel {

	private List<Item> internalList;
	private String[] header = new String[] {"Código","Cod_Pedido","Cod_Produto","Qtd"};

	public ItemTableModel(List<Item> newList) {
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
			return item.getPedido();
		} else if(column == 2) {
			return item.getProduto();
		} else if(column ==3){
			return item.getQuantidade();
		}
		return item;
	}
	
}
