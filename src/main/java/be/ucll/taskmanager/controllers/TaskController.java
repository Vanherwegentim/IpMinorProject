package be.ucll.taskmanager.controllers;

import be.ucll.taskmanager.model.domain.SubTask;
import be.ucll.taskmanager.model.domain.Task;
import be.ucll.taskmanager.model.dto.TaskDTO;
import be.ucll.taskmanager.model.service.TaskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {
    @Autowired
    private TaskServiceImp service;

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/tasks")
    public String overview(Model model){


        model.addAttribute("tasks", service.getAllTasks());
        return "overview";
    }

    @GetMapping("/tasks/edit/{id}")
    public String editPage(@PathVariable("id") int id, Model model){
        Task task = service.getTask(id);

        model.addAttribute("task",task);
        return "edit";
    }

    @GetMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable("id") int id,Model model){
        service.removeTask(id);
        return "redirect:/tasks";
    }




    @PostMapping("/tasks/edited/{id}")
    public String editTask(@ModelAttribute TaskDTO task,  @PathVariable("id") int id){
        service.edit(task, id);
        return "redirect:/tasks/" + id;
    }



    @GetMapping("/tasks/{id}")
    public String getTask(Model model, @PathVariable("id") int id){
        Task task = service.getTask(id);
        model.addAttribute("task",task);
        model.addAttribute("subTasks",task.getAllSubTasks());
        return "detail";
    }

    @GetMapping("/tasks/new")
    public String getNew(){

        return "new";

    }

    @PostMapping("/tasks")
    public String addTask(@ModelAttribute TaskDTO task){

        service.addTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/sub/create")
    public String getSubCreate(@PathVariable("id") int id, Model model){
        Task task = service.getTask(id);
        model.addAttribute("task",task);
        return "create";
    }

    @PostMapping("/task/addSubtask")
    public String createSub(@RequestParam(value="idTask") String id, Model model, @ModelAttribute SubTask subTask){
        Task task = service.getTask(Integer.parseInt(id));
        service.addSubtask(task,subTask);
        return "redirect:/tasks/"+ task.getId();


    }
}
