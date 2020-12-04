package com.bravi.task.service;

import com.bravi.task.model.Task;
import com.bravi.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Page<Task> list(Pageable pageable){
        return taskRepository.findAll(pageable);
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public Task findById(Long id){
        return taskRepository.findById(id).get();
    }

}
