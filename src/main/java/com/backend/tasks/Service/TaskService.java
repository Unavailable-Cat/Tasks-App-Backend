package com.backend.tasks.Service;

import com.backend.tasks.DTO.TaskRequestDTO;
import com.backend.tasks.DTO.TaskResponseDTO;
import com.backend.tasks.Model.Task;
import com.backend.tasks.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public ResponseEntity<TaskResponseDTO> getTask(String id) {
        Optional<Task> task=taskRepository.findById(id);
        if(!(task.isPresent())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapTaskToTaskDTO(task.get()));
    }

    public ResponseEntity<List<TaskResponseDTO>> getTasks() {
        List<Task> tasks=taskRepository.findAll();
        if(tasks.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tasks.stream().map(this::mapTaskToTaskDTO).toList());
    }

    public ResponseEntity<String> addTask(TaskRequestDTO taskRequestDTO) {
        taskRepository.save(mapTaskDTOToTask(taskRequestDTO));
        return ResponseEntity.ok("New Task Created Successfully");
    }

    public ResponseEntity<Void> updateStatus(String id, boolean status) {
        Optional<Task> task=taskRepository.findById(id);
        if(task.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        task.get().setStatus(status);
        taskRepository.save(task.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> updateTitle(String id, String title) {
        Optional<Task> task=taskRepository.findById(id);
        if(task.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        task.get().setTitle(title);
        taskRepository.save(task.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> updateDescription(String id, String description) {
        Optional<Task> task=taskRepository.findById(id);
        if(task.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        task.get().setDescription(description);
        taskRepository.save(task.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteTask(String id) {
        Optional<Task> task=taskRepository.findById(id);
        if(task.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        taskRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Task mapTaskDTOToTask(TaskRequestDTO taskRequestDTO) {
        return Task.builder()
                .title(taskRequestDTO.getTitle())
                .description(taskRequestDTO.getDescription())
                .build();
    }

    private TaskResponseDTO mapTaskToTaskDTO(Task task) {
        return TaskResponseDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.isStatus())
                .build();
    }

}
