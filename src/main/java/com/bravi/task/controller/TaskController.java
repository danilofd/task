package com.bravi.task.controller;

import com.bravi.task.model.Response;
import com.bravi.task.model.Task;
import com.bravi.task.service.TaskService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
@CrossOrigin
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Response<Page<Task>>> findAll(Pageable pageable) {
        Response<Page<Task>> response = new Response<>();
        try{
            Page<Task> tasks = taskService.list(pageable);
            if(tasks == null){
                response.getErrors().add("Error listing task!");
                return ResponseEntity.badRequest().body(response);
            }
            response.setData(tasks);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.getErrors().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

    }

    @PostMapping
    public ResponseEntity<Response<Task>> create(@RequestBody Task task) {
        Response<Task> response = new Response<>();
        try {
            response.setData(taskService.save(task));
        } catch (DuplicateKeyException dE) {
            response.getErrors().add("Task already registered!");
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            response.getErrors().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<Response<Task>> update(@RequestBody Task task) {
        Response<Task> response = new Response<>();
        try {
            response.setData(taskService.save(task));
        } catch (Exception e) {
            response.getErrors().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Response<Task>> findById(@PathVariable("id") Long id) {
        Response<Task> response = new Response<>();
        try{
            Task task = taskService.findById(id);
            if (task == null) {
                response.getErrors().add("Task not found, id:" + id);
                return ResponseEntity.badRequest().body(response);
            }
            response.setData(task);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.getErrors().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

    }

}
