package org.example.model;

import lombok.Getter;
import org.example.model.connection.DbConnection;
import org.example.model.tables.TablesTask;

import java.sql.Connection;
import java.sql.SQLException;

@Getter
public class DbManager {
    private TablesTask tablesTask;

    private DbManager() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        tablesTask = new TablesTask(connection);
    }

    private static DbManager instance = null;

    public static DbManager getInstance() throws SQLException {
        if (instance == null) instance = new DbManager();

        return instance;
    }

}