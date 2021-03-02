package Test.dao;

import Test.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void add(User user) throws SQLException;
    void delete(User user);
    void update(User user);
    List<User> getAll() throws SQLException;
    List<Long> searchUser(String name, String password) throws SQLException;

}
