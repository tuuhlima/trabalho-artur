package si5.univas.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import si5.univas.entity.Cliente;
import si5.univas.entity.Produto;

public class ProdutoDAO extends GenericDAO<Produto, Integer> {

	public ProdutoDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdutoDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	
	public void persist(Produto produto) {
        try {
                 entityManager.getTransaction().begin();
                 entityManager.persist(produto);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
	}

	/*
	SELECT 
		pr.*
	FROM
		Produto pr
		JOIN Item it
			JOIN Pedido p
				JOIN Cliente c
				ON c.cod = p.cod_cliente
			ON it.cod_pedido = p.cod
		ON pr.cod = it.cod_produto
	WHERE
		c.cod = ?
 
 */

	@SuppressWarnings("unchecked")
	public ArrayList<Produto> findByClient(Cliente cliente) {
		
		String hql = "	SELECT"
				+ "			pr"
				+ "		FROM"
				+ "			Produto pr"
				+ "			JOIN pr.items it"
				+ " 	WHERE"
				+ "			it.pedido.cliente = :cliente ";
		
		Query query = entityManager.createQuery(hql);
		query.setParameter("cliente", cliente);
		
		return (ArrayList<Produto>) query.getResultList();
	}
	
}
