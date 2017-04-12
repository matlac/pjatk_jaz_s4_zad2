package repositories;

import java.sql.SQLException;

public interface IRepositoryCatalog {

	public IUserRepository users();
	
	public void saveAndClose() throws SQLException;
	public void save() throws SQLException;
	
}
