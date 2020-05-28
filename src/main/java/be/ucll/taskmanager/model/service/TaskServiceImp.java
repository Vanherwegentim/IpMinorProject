package be.ucll.taskmanager.model.service;

import be.ucll.taskmanager.model.domain.SubTask;
import be.ucll.taskmanager.model.domain.Task;
import be.ucll.taskmanager.model.dto.TaskDTO;
import be.ucll.taskmanager.model.repo.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImp implements TaskService {
    private final TaskRepository repo;

    public TaskServiceImp(TaskRepository repo){
        this.repo = repo;

//        Task task1 = new Task("lol", "xd", LocalDate.now(), LocalTime.MIDNIGHT);
//        this.addTask(task1);
    }
    @Override
    public List<Task> getAllTasks() {
        List<Task> xd = new ArrayList<>();
        for (int i : repo.getMaps().keySet()){
            xd.add(repo.getTask(i));
        }
        return xd;
    }

    @Override
    public TaskDTO addTask(TaskDTO taskdto) {
        int id = 0;
        int length = repo.getMaps().size();
        id = length;

        Task task = new Task(taskdto.getTitle(),taskdto.getDescription(),taskdto.getDate(),taskdto.getTime());
        task.setId(id);
        repo.getMaps().put(id,task);
        return taskdto;
    }



    @Override
    public TaskDTO getTaskDTO(int id) {

        Task task = repo.getTask(id);
        TaskDTO taskDTO = new TaskDTO(task.getTitle(),task.getDescription(),task.getDate(),task.getTime());
        taskDTO.setSubTasks(task.getAllSubTasks());
        taskDTO.setId(id);
        return taskDTO;


    }

    @Override
    public void removeTask(int id) {
        repo.removeTask(id);
    }


public void edit(TaskDTO task2, int id)  {
    Task task = repo.getTask(id);

    task.setTitle(task2.getTitle());
    task.setDescription(task2.getDescription());
    task.setDate(task2.getDate());
    task.setTime(task2.getTime());
    task.maakLocalDateTime(task2.getDate(),task2.getTime());


}

public void addSubtask(TaskDTO taskdto, SubTask subTask){
        Task task = new Task(taskdto.getTitle(),taskdto.getDescription(),taskdto.getDate(),taskdto.getTime());
        for(Task task1: repo.getMaps().values()){
            if(task1.equals(task)){
                task1.addSubTask(subTask);
            }
        }
}
public Task getTaskByTitle(String title){
        Task task1 = null;
        for(Task task: this.getAllTasks()){
            if(task.getTitle().equals(title)){
                task1 = task;
            }
        }
        return task1;
}

}
