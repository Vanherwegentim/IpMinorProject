package be.ucll.taskmanager.model.service;

import be.ucll.taskmanager.model.domain.Task;
import be.ucll.taskmanager.model.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    TaskDTO addTask( TaskDTO taskdto);

    TaskDTO getTaskDTO(int id);
    void removeTask(int id);
}


