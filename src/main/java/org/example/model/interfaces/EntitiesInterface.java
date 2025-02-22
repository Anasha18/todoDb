package org.example.model.interfaces;

import org.example.model.entities.TaskEntities;

import java.sql.SQLException;
import java.util.List;

public interface EntitiesInterface {

    public List<TaskEntities> getAllTasks() throws SQLException;

    public void addTask(TaskEntities taskEntities) throws SQLException;

    public void deleteTask(int id) throws SQLException;

    public void updateTask(TaskEntities taskEntities) throws SQLException;

    public TaskEntities getTask(int id) throws SQLException;

}
