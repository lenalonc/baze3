/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;

/**
 *
 * @author user
 */
public class DBConnectionFactory {

    private Connection connection;

    private static DBConnectionFactory instance;

    private DBConnectionFactory() {

    }

    public static DBConnectionFactory getInstance() {
        if (instance == null) {
            instance = new DBConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws IOException, SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("config/dbconfig.properties"));
                String url = properties.getProperty("url");
                String username = properties.getProperty("username");
                String password = properties.getProperty("password");

                connection = DriverManager.getConnection(url, username, password);
                connection.setAutoCommit(false);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DBConnectionFactory.class.getName()).log(Level.SEVERE, "File for database configuration not found", ex);
            } catch (SQLException ex) {
                Logger.getLogger(DBConnectionFactory.class.getName()).log(Level.SEVERE, "Unable to connect to database", ex);
            }
        }
        return connection;

    }

}
