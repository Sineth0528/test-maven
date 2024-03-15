package com.kushan.abclab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

import com.kushan.abclab.model.UserLoginModel;

public class UserLoginDao {
    
    public DbConnector getDbConnector() {
        DbConnectorFactory factory = new MySqlDbConnectorFactoryImpl();
        return factory.getDbConnector();
    }
    
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        DbConnector connector = getDbConnector();
        return connector.getDbConnection();
    }
    
    public boolean CheckUserLogin(UserLoginModel UserLoginModel) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        
        try (connection) {
            String usercheckQuery = "SELECT * FROM user WHERE user_id = ?";

            try (PreparedStatement statement = connection.prepareStatement(usercheckQuery)) {
                statement.setString(1, UserLoginModel.getUserName());
                ResultSet resultSet = statement.executeQuery();
                
                if (resultSet.next()) {
                    String hashedPassword = resultSet.getString("password");
                    String providedPassword = UserLoginModel.getPassword();
                    
                    if (BCrypt.checkpw(providedPassword, hashedPassword)) {
                        return true; // Passwords match
                    }
                }
                
                return false; // No matching user or incorrect password
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
            return false;
        }
    }

}
