package org.example.model.connection;

import lombok.Getter;
import org.example.cred.SecretManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class DbConnection {
    private Connection connection;

    private DbConnection() throws SQLException {
    connection = DriverManager.getConnection(SecretManager.URL, SecretManager.USER, SecretManager.PASSWORD);
    }


    private static DbConnection instance = null;

    public static DbConnection getInstance() throws SQLException {
        if (instance == null) instance = new DbConnection();

        return instance;
    }
}
