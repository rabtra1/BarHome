package com.example.barhome.database;



import com.example.barhome.config.DataBase;
import com.example.barhome.controllers.ListOfDevicesController;
import java.sql.*;

public class CheckAuth implements DataBase {
    public static Boolean status = false;
    public static Boolean checkPassword = false;

    public Boolean getAuth_status() {
        return auth_status;
    }

    public Boolean auth_status = false;
    public static Boolean find_user(String login) {

        try (Connection connection = DriverManager.getConnection(url, userName, password); Statement statement = connection.createStatement()) {
            String sql_req = String.format("select * from users where login='%s'", login);
            ResultSet resultSet = statement.executeQuery(sql_req);

            for (;resultSet.next();) {
                String res = resultSet.getString("login");

                if (res.equals(login)) {
                    System.out.println("this user already exists");
                    status = true;
                    break;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return status;
    }

    public static Boolean checkPassword(String password_field) throws ClassNotFoundException {
        String result = "";

        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection(url, userName, password); Statement statement = connection.createStatement()) {
            String sql_req = String.format("select password from users where login='%s'", ListOfDevicesController.getLogin());
            ResultSet resultSet = statement.executeQuery(sql_req);

            for (; resultSet.next();) {
                result = resultSet.getString("password");
                if (password_field.equals(result)) {
                    checkPassword = true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return checkPassword;
    }

    public Boolean find_pass_and_user(String login, String pass) {
        try (Connection connection = DriverManager.getConnection(url, userName, password); Statement statement = connection.createStatement()) {
            String sql_req = String.format("select * from users where login='%s'", login);
            ResultSet resultSet = statement.executeQuery(sql_req);
            for (;resultSet.next();) {
                String res_log = resultSet.getString("login");
                String res_pass = resultSet.getString("password");
                if (login.equals(res_log) && pass.equals(res_pass)) {
                    auth_status = true;
                    break;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getAuth_status();
    }

}
