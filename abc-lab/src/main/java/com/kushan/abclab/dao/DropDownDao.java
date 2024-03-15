package com.kushan.abclab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kushan.abclab.model.AppointmentInfo;
import com.kushan.abclab.model.DropDownModel;

public class DropDownDao {
    
    
    public List<DropDownModel> getAllAppointName() throws SQLException, ClassNotFoundException {
    	
    	String SELECT_APPOINTMENT_TYPES = "SELECT * FROM appoint_type WHERE status = ?";
        List<DropDownModel> typeList = new ArrayList<>();
        
        try (Connection connection = getDbConnector().getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_APPOINTMENT_TYPES)) {
            preparedStatement.setString(1, "1"); // Set status parameter
            
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    DropDownModel typeapp = new DropDownModel();
                    typeapp.setId(rs.getInt("id"));
                    typeapp.setLabel(rs.getString("name"));
                    typeList.add(typeapp);
                }
            }
        } catch (SQLException e) {
            // Handle or log the exception
            throw new SQLException("Error fetching appointment types", e);
        }
        return typeList;
    }
    
    private DbConnector getDbConnector() {
        DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl();
        return factory.getDbConnector();
    }
    
    
    public AppointmentInfo CheckAvilabaleDate(String appointmentId) throws SQLException, ClassNotFoundException {
        String date = null;
        String price = null;
        String query = "SELECT IF((SELECT COUNT(*) FROM user_appoint WHERE appointment_id = ?) < b.count_day, MAX(a.`date`), MAX(a.`date`) + INTERVAL 1 DAY) AS max_date FROM user_appoint a INNER JOIN appoint_type b ON a.appointment_id = b.id WHERE a.appointment_id = ? AND a.`date` = (SELECT MAX(date) FROM user_appoint WHERE appointment_id = ? AND b.status = ? AND a.status <> ?)";

        AppointmentInfo appointmentInfo = null;
        try (Connection connection = getDbConnector().getDbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, appointmentId);
            preparedStatement.setString(2, appointmentId);
            preparedStatement.setString(3, appointmentId);
            preparedStatement.setInt(4, 1);
            preparedStatement.setInt(5, 4);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    date = rs.getString("max_date");
                }
            }

            String priceQuery = "SELECT charge FROM appoint_type WHERE id = ?";
            try (PreparedStatement preparedStatement1 = connection.prepareStatement(priceQuery)) {
                preparedStatement1.setString(1, appointmentId);
                try (ResultSet rs1 = preparedStatement1.executeQuery()) {
                    while (rs1.next()) {
                        price = rs1.getString("charge");
                    }
                }
            }
            
            appointmentInfo = new AppointmentInfo(date, price);
        } catch (SQLException e) {
            // Handle or log the exception
            throw new SQLException("Error fetching appointment types", e);
        }
        return appointmentInfo;
    }

}
