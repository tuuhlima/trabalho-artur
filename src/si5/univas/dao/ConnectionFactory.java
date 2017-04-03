package si5.univas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import si5.univas.dao.DAOException;

public class ConnectionFactory {

	public static Connection createConnection() throws DAOException {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/TrabalhoArtur", "postgres", "abc123");
		} catch (SQLException exception) {
			throw new DAOException(exception);
		}
	}
	
}
