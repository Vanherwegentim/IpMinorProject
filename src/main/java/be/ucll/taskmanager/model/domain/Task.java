package be.ucll.taskmanager.model.domain;

import be.ucll.taskmanager.model.service.ServiceException;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Task {

    private String description;
    private int id;
    private LocalDateTime datetime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime time;
    private String title;
    private List<SubTask> lijst;

    public Task (String title, String description, LocalDate date, LocalTime time){
        if(description == null || description.trim().isEmpty()){
              throw new ServiceException("Description mag niet leeg zijn");
        }
        if(date == null){
            throw new ServiceException("tijdstip is null");
        }
        this.description = description;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.date= date;
        this.time = time;
        this.datetime = LocalDateTime.of(this.date.getYear(),this.date.getMonth(),this.date.getDayOfMonth(),this.time.getHour(),this.time.getMinute());

        this.title = title;
        lijst = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId(){
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public LocalDateTime getTijdstip() {
        return datetime;
    }

    public void setTijdstip(LocalDateTime tijdstip) {
        this.datetime = tijdstip;
    }

    public void maakLocalDateTime(LocalDate date, LocalTime tijd){
        this.datetime = LocalDateTime.of(date.getYear(),date.getMonth(),date.getDayOfMonth(),tijd.getHour(),tijd.getMinute());
    }
    public String toString(){
        return " " + this.datetime.toString();
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void addSubTask(SubTask subTask){
        this.lijst.add(subTask);
    }

    public List<SubTask> getAllSubTasks(){
        return lijst;
    }






}


