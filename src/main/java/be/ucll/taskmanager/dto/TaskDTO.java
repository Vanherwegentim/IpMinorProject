package be.ucll.taskmanager.dto;

import be.ucll.taskmanager.service.ServiceException;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TaskDTO {
    private String description;
    private int id;
    private LocalDateTime datetime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime time;
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

    }

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
}
