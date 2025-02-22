package org.example.service;

import org.example.model.DbManager;
import org.example.model.entities.TaskEntities;

import java.util.List;

public class TodoService {

    private DbManager dbManager;

    public TodoService() throws Exception {
        try {
            dbManager = DbManager.getInstance();
        } catch (Exception e) {
            throw new Exception("Ошибка инциализации БД");
        }
    }

    public List<TaskEntities> getAllTasks() throws Exception {
        try {
            List<TaskEntities> taskEntities = dbManager.getTablesTask().getAllTasks();

            taskEntities.forEach(System.out::println);

            return taskEntities;
        } catch (Exception e) {
            throw new Exception("Ошибка получения данных с БД");
        }
    }

    public void addTask(TaskEntities taskEntities) throws Exception {
        try {
            dbManager.getTablesTask().addTask(taskEntities);
        } catch (Exception e) {
            throw new Exception("Ошибка добавления задачи в БД");
        }
    }

    public void deleteTask(int id) throws Exception {
        try {
            dbManager.getTablesTask().deleteTask(id);
        } catch (Exception e) {
            throw new Exception("Ошибка уделения задачи из БД");
        }
    }

    public TaskEntities getTask(int id) throws Exception {
        try {
            return dbManager.getTablesTask().getTask(id);
        } catch (Exception e) {
            throw new Exception("Ошибка получения задачи их БД");
        }
    }

    public void updateTusk(TaskEntities taskEntities) throws Exception {
        try {
            dbManager.getTablesTask().updateTask(taskEntities);
        } catch (Exception e) {
            throw new Exception("Ошибка обновления задачи в БД");
        }

    }
}
