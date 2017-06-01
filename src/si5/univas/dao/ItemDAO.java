package si5.univas.dao;

import javax.persistence.EntityManager;

import edu.univas.si4.entity.Item;

public class ItemDAO extends GenericDAO<Item, Integer> {

	public ItemDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
