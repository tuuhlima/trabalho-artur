package si5.univas.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import si5.univas.entity.Produto;

public class ProdutoTableModel extends DefaultTableModel {
	
	private ArrayList<Produto> internalList;
	private String[] header = new String[] {"Código","Nome","Quantidade estoque"};

	public ProdutoTableModel(ArrayList<Produto> newList) {
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
		Produto produto = internalList.get(row);
		if (column == 0) {
			return produto.getCod();
		} else if (column == 1) {
			return produto.getNome();
		} else if(column == 2) {
			return produto.getQtd();
		}
		return produto;
	}
	
}
