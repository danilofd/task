package com.bravi.task.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private LocalDate scheduleTaskDate;

    private LocalDate dateFinish;

    private Integer timeSpend;

    @OneToMany(mappedBy="task", fetch = FetchType.LAZY)
    private List<TaskComments> comments;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getScheduleTaskDate() {
        return scheduleTaskDate;
    }

    public void setScheduleTaskDate(LocalDate scheduleTaskDate) {
        this.scheduleTaskDate = scheduleTaskDate;
    }

    public LocalDate getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    public Integer getTimeSpend() {
        return timeSpend;
    }

    public void setTimeSpend(Integer timeSpend) {
        this.timeSpend = timeSpend;
    }

    public List<TaskComments> getComments() {
        return comments;
    }

    public void setComments(List<TaskComments> comments) {
        this.comments = comments;
    }
}
