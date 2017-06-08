package si5.univas.model;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import si5.univas.entity.Item;

public class ItemTableModel extends DefaultTableModel {

	private List<Item> internalList;
	private String[] header = new String[] {"Nome","Data","Pedido","Produto","Quantidade"};

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
		SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy");
		if (column == 0) {
			return item.getPedido().getCliente().getNome();
		} else if (column == 1) {
			return dateFormate.format(item.getPedido().getData());
		} else if(column == 2) {
			return item.getPedido();
		} else if(column ==3){
			return item.getProduto().getNome();
		} else if(column==4){
			return item.getQuantidade();
		}
		return item;
	}
	
}
