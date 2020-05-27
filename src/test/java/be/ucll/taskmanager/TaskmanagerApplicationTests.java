package be.ucll.taskmanager;

import be.ucll.taskmanager.model.domain.Task;
import be.ucll.taskmanager.model.dto.TaskDTO;
import be.ucll.taskmanager.model.repo.TaskRepository;
import be.ucll.taskmanager.model.service.TaskService;
import be.ucll.taskmanager.model.service.TaskServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@SpringBootTest
class TaskmanagerApplicationTests {
    @Autowired
    TaskService service = new TaskServiceImp(new TaskRepository());

    @Test
    public void testGetTasks(){
        //setup
        TaskDTO taskdto = new TaskDTO("Stofzuigen", "De slaapkamer moet gestofzuigt worden",LocalDate.of(2020,03,31), LocalTime.of(20,00));
        service.addTask(taskdto);

        //method to be tested
        List<Task> tasks = service.getAllTasks();

        //checks
        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        assertEquals(2,tasks.size());
        Task task = tasks.get(0);
        assertNotNull(task);




    }

    @Test
    public void testAddTask(){
        // setup
        TaskDTO taskdto = new TaskDTO("Stofzuigen", "De slaapkamer moet gestofzuigt worden",LocalDate.of(2020,03,31), LocalTime.of(20,00));

        // method to be tested
        service.addTask(taskdto);

        //checks
        assertNotNull(taskdto);
        assertEquals(3,service.getAllTasks().size());
        Task task = service.getAllTasks().get(1);
        assertNotNull(task);
    }

}
