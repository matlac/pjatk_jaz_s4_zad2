package repositories;

import java.sql.Connection;
import java.sql.SQLException;

import repositories.mappers.*;
import repositories.uow.IUnitOfWork;
import repositories.uow.UnitOfWork;

public class RepositoryCatalog implements IRepositoryCatalog {

	IUserRepository userRepo;

	IUnitOfWork uow;
	Connection connection;
	
	public RepositoryCatalog(Connection connection) throws SQLException {
		this.connection = connection;
		uow = new UnitOfWork(connection);

		userRepo = new UserRepository(connection, new UserMapper(), uow);
	}

	public IUserRepository users() {
		return userRepo;
	}

	public void saveAndClose() throws SQLException {
		uow.saveChanges();
		connection.close();
		connection=null;
	}
	
	public void save() throws SQLException {
		uow.saveChanges();
	}

}
