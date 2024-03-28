package com.example.restulapi;

import com.example.restulapi.model.tasks;
import com.example.restulapi.repo.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/taskses")
public class tasksController {

    @Autowired
    private TasksRepository tasksRepo;

    @GetMapping
    public ResponseEntity<List<tasks>> getAllTasks() {
        List<tasks> allTasks = tasksRepo.findAll();
        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<tasks> getTaskById(@PathVariable Integer id) {
        Optional<tasks> optionalTask = tasksRepo.findById(id);
        if (optionalTask.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalTask.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<tasks> createTask(@RequestBody tasks task) {
        tasks createdTask = tasksRepo.save(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<tasks> updateTask(@PathVariable Integer id, @RequestBody tasks taskDetails) {
        Optional<tasks> optionalTask = tasksRepo.findById(id);
        if (optionalTask.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tasks existingTask = optionalTask.get();
        existingTask.setTitle(taskDetails.getTitle());
        existingTask.setDescription(taskDetails.getDescription());
        existingTask.setStatus(taskDetails.getStatus());
        tasks updatedTask = tasksRepo.save(existingTask);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        Optional<tasks> optionalTask = tasksRepo.findById(id);
        if (optionalTask.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tasksRepo.delete(optionalTask.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


