package org.example.model.tables;

import lombok.AllArgsConstructor;
import org.example.model.entities.TaskEntities;
import org.example.model.interfaces.EntitiesInterface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TablesTask implements EntitiesInterface {
    private Connection connection;

    public TablesTask(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<TaskEntities> getAllTasks() throws SQLException {
        List<TaskEntities> taskEntities = new ArrayList<>();

        Statement statement = connection.createStatement();

        String selectQuery = String.format("SELECT * FROM todo ORDER BY id");

        ResultSet resultSet = statement.executeQuery(selectQuery);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            String createdTime = resultSet.getString("created_time");

            taskEntities.add(new TaskEntities(id, title, description, createdTime));
        }
        resultSet.close();
        statement.close();

        return taskEntities;
    }

    @Override
    public void addTask(TaskEntities taskEntities) throws SQLException {
        Statement statement = connection.createStatement();

        String insertQuery = String.format("INSERT INTO todo (title, description, created_time) VALUES ('%s','%s', '%s')", taskEntities.getTitle(), taskEntities.getDescription(), taskEntities.getCreatedTime());

        statement.executeUpdate(insertQuery);

        statement.close();
    }

    @Override
    public void deleteTask(int id) throws SQLException {
        Statement statement = connection.createStatement();

        String deleteQuery = String.format("DELETE FROM todo WHERE id = %d", id);

        statement.executeUpdate(deleteQuery);

        statement.close();
    }

    @Override
    public void updateTask(TaskEntities taskEntities) throws SQLException {
        Statement statement = connection.createStatement();

        String updateQuery = String.format("UPDATE todo SET title = '%s', description = '%s', created_time = '%s' WHERE id = %d", taskEntities.getTitle(), taskEntities.getDescription(), taskEntities.getCreatedTime(), taskEntities.getId());

        statement.executeUpdate(updateQuery);
    }

    @Override
    public TaskEntities getTask(int searchId) throws SQLException {
        TaskEntities taskEntities = null;

        Statement statement = connection.createStatement();

        String selectTaskQuery = String.format("UPDATE todo SET description = '' WHERE id = %d", searchId);

        ResultSet resultSet = statement.executeQuery(selectTaskQuery);
        resultSet.next();

        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String description = resultSet.getString("description");
        String createdTime = resultSet.getString("created_time");

        taskEntities = new TaskEntities(id, title, description, createdTime);

        resultSet.close();
        statement.close();

        return taskEntities;

    }
}
