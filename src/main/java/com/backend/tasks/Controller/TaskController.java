package com.backend.tasks.Controller;

import com.backend.tasks.DTO.TaskRequestDTO;
import com.backend.tasks.DTO.TaskResponseDTO;
import com.backend.tasks.Model.Task;
import com.backend.tasks.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("{id}")
    public ResponseEntity<TaskResponseDTO> getTask(@PathVariable String id){
        return service.getTask(id);
    }

    @GetMapping("")
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks(){
        return service.getTasks();
    }

    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody TaskRequestDTO taskRequestDTO){
        return service.addTask(taskRequestDTO);
    }

    @PatchMapping("{id}/status")
    public ResponseEntity<Void> updateTaskStatusCompleted(@PathVariable String id, @RequestBody boolean status){
        return service.updateStatus(id,status);
    }

    @PatchMapping("{id}/title")
    public ResponseEntity<Void> updateTaskTitleCompleted(@PathVariable String id, @RequestBody String title){
        return service.updateTitle(id,title);
    }

    @PatchMapping("{id}/description")
    public ResponseEntity<Void> updateTaskDescriptionCompleted(@PathVariable String id, @RequestBody String description){
        return service.updateDescription(id,description);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id){
        return service.deleteTask(id);
    }
}
