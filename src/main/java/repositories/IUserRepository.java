package repositories;

import domain.User;

import java.util.List;

public interface IUserRepository extends IRepository<User> {

    public User withId(int id);
    public List<User> listUsersWithoutAdmins();
    public List<User> listUsers();
    public User withLoginAndEmail(String login, String password);
    public User withLoginAndPassword(String login, String password);

}
