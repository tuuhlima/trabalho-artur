package si5.univas.model;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

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
<<<<<<< HEAD
	public Produto getSelectedItem() {
=======
	public Object getSelectedItem() {
>>>>>>> 55bbe1c30dc83b3cbf3a472192ba432870660376
		return produtoSelecionado;
	}

	@Override
	public void setSelectedItem(Object produto) {
		produtoSelecionado = (Produto)produto;
	}

	
	
}
