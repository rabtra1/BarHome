package com.example.barhome.database;




import com.example.barhome.config.DataBase;
import com.example.barhome.controllers.ListOfDevicesController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Input implements DataBase {
    public static void input(String login, String pass, String api_token, String client_id) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager.getConnection(url, userName, password); Statement statement = connection.createStatement()) {
            String sql_req_to_users = String.format("insert into users(login, password, api_token, client_id) values ('%s', '%s', '%s', '%s')",
                    login,
                    pass,
                    api_token,
                    client_id);
            statement.executeUpdate(sql_req_to_users);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void inputDevice(String nameOfDevice, String scenario_id_on, String scenario_id_off, String login) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager.getConnection(url, userName, password); Statement statement = connection.createStatement()) {
            String sql_req_to_users = String.format("insert into devices(name_of_device, scenario_id_on, scenario_id_off ,login) values ('%s', '%s', '%s', '%s')",
                    nameOfDevice,
                    scenario_id_on,
                    scenario_id_off,
                    login);
            statement.executeUpdate(sql_req_to_users);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteDevice(String nameOfDevice, String login) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager.getConnection(url, userName, password); Statement statement = connection.createStatement()) {
            String sql_req = String.format("delete from devices where name_of_device='%s' and login='%s'", nameOfDevice, login);
            statement.executeUpdate(sql_req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeLogin(String newLogin) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager.getConnection(url, userName, password); Statement statement = connection.createStatement()) {
            String sql_req = String.format("update users set login='%s' where login='%s';", newLogin, ListOfDevicesController.getLogin());
            statement.executeUpdate(sql_req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changePassword(String newPassword) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager.getConnection(url, userName, password); Statement statement = connection.createStatement()) {
            String sql_req = String.format("update users set password='%s' where login='%s';", newPassword, ListOfDevicesController.getLogin());
            statement.executeUpdate(sql_req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeApiToken(String newApiToken) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager.getConnection(url, userName, password); Statement statement = connection.createStatement()) {
            String sql_req = String.format("update users set api_token='%s' where login='%s';", newApiToken, ListOfDevicesController.getLogin());
            statement.executeUpdate(sql_req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeClientId(String newClientId) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager.getConnection(url, userName, password); Statement statement = connection.createStatement()) {
            String sql_req = String.format("update users set client_id='%s' where login='%s';", newClientId, ListOfDevicesController.getLogin());
            statement.executeUpdate(sql_req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
