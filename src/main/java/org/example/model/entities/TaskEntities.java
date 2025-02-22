package org.example.model.entities;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TaskEntities {
    private int id;
    private String title;
    private String description;
    private String createdTime;

    public TaskEntities(String title, String description, String createdTime) {
        this.title = title;
        this.description = description;
        this.createdTime = createdTime;
    }

    public TaskEntities(int id, String title, String description, String createdTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdTime = createdTime;
    }
}
