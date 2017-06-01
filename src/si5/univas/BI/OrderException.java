package si5.univas.BI;
import si5.univas.entity.Produto;


public class OrderException extends Exception {

	private static final long serialVersionUID = 1L;
	private Produto produto;
	
	private int qtd;
	
	public OrderException(Produto produto, int qtd) {
		super();
		this.produto = produto;
		this.qtd = qtd;
	}

	public OrderException() {
		// TODO Auto-generated constructor stub
	}

	public Produto getProduct() {
		return produto;
	}

	public void setProduct(Produto produto) {
		this.produto = produto;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
}
