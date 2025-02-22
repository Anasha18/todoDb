package org.example.model.connection;

import lombok.Getter;
import org.example.util.secretManagerCred.SecretManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class DbConnection {
    private Connection connection;

    private DbConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://83.147.246.87:5432/barkovskii_2323d_learning_db", "barkovskii_2323d_learning_user", "12345");
    }

    private static DbConnection instance = null;

    public static DbConnection getInstance() throws SQLException {
        if (instance == null) instance = new DbConnection();

        return instance;
    }
}
