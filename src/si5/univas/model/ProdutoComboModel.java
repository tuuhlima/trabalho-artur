package si5.univas.model;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import si5.univas.entity.Produto;

public class ProdutoComboModel implements ComboBoxModel<Produto> {

	private ArrayList<Produto> produtos = new ArrayList<>();
	private Produto produtoSelecionado = null;
	
	public ProdutoComboModel(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}	
	
	@Override
	public void addListDataListener(ListDataListener arg0) {
		
	}

	@Override
	public Produto getElementAt(int i) {
		return produtos.get(i);
	}

	@Override
	public int getSize() {
		return produtos.size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		
	}

	@Override
	public Produto getSelectedItem() {
		return produtoSelecionado;
	}

	@Override
	public void setSelectedItem(Object produto) {
		produtoSelecionado = (Produto)produto;
	}

	
	
}
