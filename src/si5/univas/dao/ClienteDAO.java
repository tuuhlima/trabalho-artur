package si5.univas.dao;

import java.util.List;

import javax.persistence.TypedQuery;

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

	public List<Cliente> pesquisarClientes() {
		TypedQuery<Cliente> query = entityManager.createQuery("from Cliente c", Cliente.class);
		return query.getResultList();
	}

}
