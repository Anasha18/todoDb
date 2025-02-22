package org.example;

import org.example.model.entities.TaskEntities;
import org.example.service.TodoService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        int action;
        Scanner scanner = new Scanner(System.in);
        TodoService todoService = null;

        try {
            todoService = new TodoService();
        } catch (Exception e) {
            System.out.println("Приложение будет закрыто: " + e.getMessage());
            System.exit(0);
        }

        while (true) {
            System.out.println("Меню");
            System.out.println("1. Посмоттреть все задачи");
            System.out.println("2. Добавить новую задачу");
            System.out.println("3. Удалить задачу по id");
            System.out.println("4. Обновить задачу по id");
            System.out.println("5. Закрыть приложение");

            System.out.print("Выберите дейсвтие: ");
            action = scanner.nextInt();

            switch (action) {
                case 1: {
                    try {
                        List<TaskEntities> tasks = todoService.getAllTasks();

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case 2: {
                    try {
                        System.out.print("Введите название для задачи: ");
                        String title = scanner.next();

                        System.out.print("Введите описание для задачи: ");
                        String description = scanner.next();

                        System.out.print("Введите дату в формате (31-12-2025): ");
                        String date = scanner.next();

                        todoService.addTask(new TaskEntities(title, description, date));

                        System.out.println("Пользователь успешно добавлен");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case 3: {
                    try {

                        List<TaskEntities> tasks = todoService.getAllTasks();

                        System.out.print("Введите id задачи для удаления: ");
                        int id = scanner.nextInt();

                        todoService.deleteTask(id);
                        System.out.println("Задача успешно удалена!");

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case 4: {
                    try {
                        List<TaskEntities> tasks = todoService.getAllTasks();

                        System.out.print("Введите id задачи для обновления описания у задачи: ");
                        int id = scanner.nextInt();

                        System.out.print("Введите название для задачи: ");
                        String title = scanner.next();

                        System.out.print("Введите описание для задачи: ");
                        String description = scanner.next();

                        System.out.print("Введите дату в формате (31-12-2025): ");
                        String date = scanner.next();

                        todoService.updateTusk(new TaskEntities(id, title, description, date));

                        System.out.println("Пользователь успешно обновлен!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case 5: {
                    System.out.println("Приложение будет закрыто!");
                    System.exit(0);
                }
            }
        }
    }
}