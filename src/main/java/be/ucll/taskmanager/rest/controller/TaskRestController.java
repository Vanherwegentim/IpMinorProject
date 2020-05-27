package be.ucll.taskmanager.rest.controller;


import be.ucll.taskmanager.model.domain.Task;
import be.ucll.taskmanager.model.dto.TaskDTO;
import be.ucll.taskmanager.model.service.TaskService;
import be.ucll.taskmanager.model.service.TaskServiceImp;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskRestController {
    private final TaskService taskService;
    public TaskRestController(TaskServiceImp taskServiceImp){
        this.taskService = taskServiceImp;
    }

    @GetMapping("/tasks")
    @ResponseBody
    public List<Task> overview(){
        return taskService.getAllTasks();
    }

    @PostMapping("/tasks")
    public TaskDTO addTask(@RequestBody @Valid TaskDTO taskDTO){
             return  taskService.addTask(taskDTO);

    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable("id") int id){
         return taskService.getTask(id);

    }
}
