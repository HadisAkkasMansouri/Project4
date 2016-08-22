package ir.dotin.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    static Connection connection = null;

    public static int addCustomer(String customerNumber) throws SQLException {

        int id = retrieveMaxId();
        connection = SingleConnection.getConnection();
        String query = "INSERT INTO CUSTOMER(ID, CUSTOMER_NUMBER) values (?, ?);";
        System.out.println(query);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, customerNumber);
        preparedStatement.executeUpdate();
        return id;
    }

    public static int retrieveMaxCustomerNumber() {

        int customerNumber = 0;
        try {
            connection = SingleConnection.getConnection();
            String query = "SELECT MAX(CUSTOMER_NUMBER) FROM CUSTOMER;";
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if (resultSet.getInt(1) != 0) {
                customerNumber = resultSet.getInt(1) + 1;
            } else {
                customerNumber = 10000;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerNumber;
    }

    public static boolean deleteCustomer(int id) {

        try {
            String query = "DELETE FROM CUSTOMER WHERE ID = ?;";
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static int retrieveMaxId() {

        int id = 0;
        try {
            connection = SingleConnection.getConnection();
            String query = "SELECT MAX(ID) FROM CUSTOMER;";
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if (resultSet.getInt(1) != 0) {
                id = resultSet.getInt(1) + 1;
            } else {
                id = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static String retrieveCustomerNumberById(int id) {

        PreparedStatement preparedStatement;
        connection = SingleConnection.getConnection();
        String customerNumber = null;
        try {
            String query = "SELECT (CUSTOMER_NUMBER) FROM CUSTOMER WHERE ID = ?;";
            System.out.println(query);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customerNumber = String.valueOf(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerNumber;
    }

    public static int retrieveIdByCustomerNumber(String customerNumber) {

        connection = SingleConnection.getConnection();
        int id = 0;
        try {
            String query = "SELECT (ID) FROM CUSTOMER WHERE CUSTOMER_NUMBER = ?;";
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customerNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
