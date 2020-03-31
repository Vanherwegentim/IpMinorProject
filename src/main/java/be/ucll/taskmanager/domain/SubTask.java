package be.ucll.taskmanager.domain;

public class SubTask {
    private String description, title;

    public SubTask(String description, String title){
        this.description = description;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
