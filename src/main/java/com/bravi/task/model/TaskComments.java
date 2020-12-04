package com.bravi.task.model;

import javax.persistence.*;

@Entity
@Table(name = "task_comment")
public class TaskComments {

    @Id
    @GeneratedValue
    private Long id;

    private String author;

    private String comment;

    @ManyToOne
    @JoinColumn(name="id_task")
    private Task task;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
