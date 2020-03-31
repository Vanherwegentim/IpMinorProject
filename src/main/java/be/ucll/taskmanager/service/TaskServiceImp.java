package be.ucll.taskmanager.service;

import be.ucll.taskmanager.domain.SubTask;
import be.ucll.taskmanager.domain.Task;
import be.ucll.taskmanager.dto.TaskDTO;
import be.ucll.taskmanager.repo.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void addTask(TaskDTO taskdto) {
        int id = 0;
        int length = repo.getMaps().size();
        id = length;

        Task task = new Task(taskdto.getTitle(),taskdto.getDescription(),taskdto.getDate(),taskdto.getTime());
        task.setId(id);
        repo.getMaps().put(id,task);
    }



    @Override
    public Task getTask(int id) {
        return repo.getTask(id);
//        Task xf = null;
//        for(Task t: tasks){
//            if(t.getId()== id){
//                xf = t;
//            }
//
//        }
////        if(xf == null){
////            throw new ServiceException("Task not found.");
////        }else {
////            return xf;
////        }
//        return xf;

    }

    @Override
    public void removeTask(int id) {
        repo.removeTask(id);
    }

    //    public static void main(String args[]){
//        Task task = new Task("lol", "xd","2020-03-12","20:00");
//        System.out.println(task.toString());
//    }
public void edit(TaskDTO task2, int id)  {
    Task task = repo.getTask(id);

    task.setTitle(task2.getTitle());
    task.setDescription(task2.getDescription());
    task.setDate(task2.getDate());
    task.setTime(task2.getTime());
    task.maakLocalDateTime(task2.getDate(),task2.getTime());


}

public void addSubtask(Task task, SubTask subTask){
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
