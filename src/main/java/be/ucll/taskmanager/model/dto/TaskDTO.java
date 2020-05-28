package be.ucll.taskmanager.model.dto;

import be.ucll.taskmanager.model.domain.SubTask;
import be.ucll.taskmanager.model.service.ServiceException;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TaskDTO {
    @NotEmpty
    private String description;
    private int id;
    private LocalDateTime datetime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate date;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @NotNull
    private LocalTime time;
    private List<SubTask> lijst;
    @NotEmpty
    private String title;
    public TaskDTO (String title, String description, LocalDate date, LocalTime time) {
        if (description == null || description.trim().isEmpty()) {
            throw new ServiceException("Description mag niet leeg zijn");
        }
        if (date == null) {
            throw new ServiceException("tijdstip is null");
        }
        this.description = description;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.date = date;
        this.time = time;
        this.datetime = LocalDateTime.of(this.date.getYear(), this.date.getMonth(), this.date.getDayOfMonth(), this.time.getHour(), this.time.getMinute());

        this.title = title;
        lijst = new ArrayList<>();

    }

    public TaskDTO(){}

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public List<SubTask> getAllSubTasks(){
        return lijst;
    }

    public void addSubTask(SubTask subTask){
        this.lijst.add(subTask);
    }

    public void setSubTasks(List<SubTask> subtasks){
        lijst = subtasks;
    }

    public void setId(int id){
        this.id = id;
    }



    public int getId() {
        return id;
    }
}
