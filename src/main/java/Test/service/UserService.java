package Test.service;

import Test.dao.ConnectionDAO;
import Test.dao.UserDAO;
import Test.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService extends ConnectionDAO implements UserDAO {
    Connection connection = getConnection();

    @Override
    public void add(User user) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO users_game( name, password) values( ?, ?)";
        System.out.println("serv : " + user.toString());

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("serv");
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> arrayList = new ArrayList<>();
        Statement statement = null;
        String sql = "SELECT userId, name, password FROM users_game";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getLong("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                arrayList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
        return arrayList;
    }

    @Override
    public long searchUser(String name, String password) {
        System.out.println(name + "  " + password);
        PreparedStatement preparedStatement = null;
        String sql = "SELECT userId FROM users_game WHERE name = ? AND password = ?";
        Long id = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            id = resultSet.getLong("userId");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}

