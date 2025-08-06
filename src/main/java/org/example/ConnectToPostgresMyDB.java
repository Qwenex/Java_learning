package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectToPostgresMyDB {
    private static final Logger logger = LoggerFactory.getLogger(ConnectToPostgresMyDB.class);

    public static ResultSet sendRequest(SwitchExecute switchExecute, String sql) throws IOException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Properties properties = new Properties();
        String url;
        String user;
        String password;

        try (InputStream input = ConnectToPostgresMyDB.class.getClassLoader()
                .getResourceAsStream("authorization/authorizationPostgresMyDB.properties")) {
            if (input == null) {
                throw new RuntimeException("Файл не найден в resources!");
            }
            properties.load(input);
            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");
        }
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            if (switchExecute == SwitchExecute.SELECT) {
                return statement.executeQuery(sql);
            } else {
                Integer rows = statement.executeUpdate(sql);
                logger.info("Было добавлено {} строк", rows);
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
