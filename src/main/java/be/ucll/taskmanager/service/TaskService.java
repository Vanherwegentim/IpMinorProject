package be.ucll.taskmanager.service;

import be.ucll.taskmanager.domain.Task;
import be.ucll.taskmanager.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    void addTask( TaskDTO taskdto);
    Task getTask(int id);
}


