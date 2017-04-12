package repositories.mappers;

import domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements IMapResultSetToEntity<User>{

	public User map(ResultSet rs) throws SQLException {
		User u = new User();
		u.setId(rs.getInt("id"));
		u.setLogin(rs.getString("login"));
		u.setEncryptedPassword(rs.getString("password"));
		u.setEmail(rs.getString("email"));
		u.setRole(rs.getInt("role"));
		return u;
	}

}
