package si5.univas.dao;

import si5.univas.entity.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Integer> {

	public void persist(Cliente cliente) {
        try {
                 entityManager.getTransaction().begin();
                 entityManager.persist(cliente);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
	}
	
}
