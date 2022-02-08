//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class UserDaoJDBCImpl extends Util implements UserDao {
//    private static final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS User " + "(id INT(5) NOT NULL AUTO_INCREMENT," + " name VARCHAR(50) NOT NULL, " + " lastname VARCHAR(50) NOT NULL, " + " age INT NOT NULL, " + "PRIMARY KEY(id));";
//    private static final String DROP_USER_TABLE = "DROP TABLE IF EXISTS User";
//    private static final String ALL_USERS = "SELECT * from User";
//    private static final String ADD_USER = "INSERT INTO User (Name, LastName, Age) VALUES (?,?,?)";
//    private static final String DELETE_USER = "DELETE FROM User WHERE id = ?";
//    private static final String CLEAN_TABLE = "TRUNCATE TABLE User";
//
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        try (Statement statement = getConnection().createStatement()) {
//            statement.execute(CREATE_USER_TABLE);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void dropUsersTable() {
//        try (Statement statement = getConnection().createStatement()) {
//            statement.execute(DROP_USER_TABLE);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        try (PreparedStatement preparedStatement = getConnection().prepareStatement(ADD_USER)) {
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void removeUserById(long id) {
//        try (PreparedStatement preparedStatement = getConnection().prepareStatement(DELETE_USER)) {
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List<User> users = new ArrayList<>();
//        try (Statement statement = getConnection().createStatement()) {
//
//            ResultSet resultSet = statement.executeQuery(ALL_USERS);
//
//            while (resultSet.next()) {
//                User newUser = new User();
//                newUser.setId(resultSet.getLong("id"));
//                newUser.setName(resultSet.getString("name"));
//                newUser.setLastName(resultSet.getString("lastname"));
//                newUser.setAge(resultSet.getByte("age"));
//                users.add(newUser);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return users;
//    }
//
//    public void cleanUsersTable() {
//        try (Statement statement = getConnection().createStatement()) {
//            statement.execute(CLEAN_TABLE);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
