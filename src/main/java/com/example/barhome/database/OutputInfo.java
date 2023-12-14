package com.example.barhome.database;


import com.example.barhome.config.DataBase;
import java.sql.*;
import java.util.HashMap;

public class OutputInfo implements DataBase {





    public static HashMap<Integer, String> listOfDevices(String login) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        HashMap<Integer, String> devices = new HashMap<>();
        try (Connection connection = DriverManager.getConnection(url, userName, password); Statement statement = connection.createStatement()) {


            String sql_req = String.format("select * from devices where login='%s'", login);
            ResultSet resultSet = statement.executeQuery(sql_req);

            for (int i = 1; resultSet.next(); i++) {
                String res = resultSet.getString("name_of_device");
                devices.put(i, res);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return devices;
    }

    public static String getScenarioIdOn(String name_of_device, String login) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String res = "";

        try (Connection connection = DriverManager.getConnection(url, userName, password); Statement statement = connection.createStatement()) {
            String sql_req = String.format("select * from devices where name_of_device='%s' and login='%s'", name_of_device, login);
            ResultSet resultSet = statement.executeQuery(sql_req);

            for (; resultSet.next() ;) {
                res = resultSet.getString("scenario_id_on");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return res;
    }

    public static String getScenarioIdOff(String name_of_device, String login) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String res = "";

        try (Connection connection = DriverManager.getConnection(url, userName, password); Statement statement = connection.createStatement()) {
            String sql_req = String.format("select * from devices where name_of_device='%s' and login='%s'", name_of_device, login);
            ResultSet resultSet = statement.executeQuery(sql_req);

            for (; resultSet.next(); ) {
                res = resultSet.getString("scenario_id_off");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return res;
    }

    public static String getApiToken(String login) throws ClassNotFoundException {
        String result = "";

        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection(url, userName, password); Statement statement = connection.createStatement()) {
            String sql_req = String.format("select api_token from users where login='%s'", login);
            ResultSet resultSet = statement.executeQuery(sql_req);

            for (; resultSet.next();) {
                result = resultSet.getString("api_token");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }




}
