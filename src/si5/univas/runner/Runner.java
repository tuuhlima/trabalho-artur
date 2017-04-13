package si5.univas.runner;

import java.sql.SQLException;

import si5.univas.controller.Controller;
import si5.univas.dao.DAOException;

public class Runner {
	
	public static void main(String[] args) throws SQLException, DAOException {
		Controller control = new Controller();
		control.iniciar();		
	}
	
}
