package si5.univas.dao;

import javax.persistence.EntityManager;

import si5.univas.entity.Item;

public class ItemDAO extends GenericDAO<Item, Integer> {

	public ItemDAO() {
		super();
	}

	public ItemDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
