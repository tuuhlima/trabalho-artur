package si5.univas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import si5.univas.entity.Item;

public class ItemDAO extends GenericDAO<Item, Integer> {

	public ItemDAO() {
		super();
	}

	public ItemDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	public List<Item> pesquisarItens() {
		TypedQuery<Item> query = entityManager.createQuery("from Item i", Item.class);
		return query.getResultList();
	}

}
