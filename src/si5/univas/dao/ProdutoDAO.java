package si5.univas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	
	public List<Produto> pesquisarProdutos() {
		TypedQuery<Produto> query = entityManager.createQuery("from Produto p", Produto.class);
		return query.getResultList();
	}

}
