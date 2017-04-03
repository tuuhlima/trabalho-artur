package si5.univas.runner;

import si5.univas.dao.ConnectionFactory;
import si5.univas.dao.DAOException;

public class TesteConnection {

	public static void main(String[] args){
		
		try {
			ConnectionFactory.createConnection();
			System.out.println("Conexão Criada");
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
}
