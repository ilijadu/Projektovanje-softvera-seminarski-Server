/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import constant.ServerKonstante;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionFactory {

    private static DBConnectionFactory instance;
    private Connection connection;

    private DBConnectionFactory() throws SQLException {
    }

    public static DBConnectionFactory getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws Exception {
        if (connection == null || connection.isClosed()) {
            Properties properties = new Properties();
            properties.load(new FileInputStream(ServerKonstante.FILE_PATH));
            String url = properties.getProperty(ServerKonstante.DB_CONFIG_URL);
            String username = properties.getProperty(ServerKonstante.DB_CONFIG_USERNAME);
            String password = properties.getProperty(ServerKonstante.DB_CONFIG_PASSWORD);
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        }
        return connection;
    }

}
