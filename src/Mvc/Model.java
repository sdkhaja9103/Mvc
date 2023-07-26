package Mvc;

public class Model {
	private String title;
    private String description;
    private String priorityLevel;
    private boolean completed;
    public Model(String title, String description, String priorityLevel) {
        this.title = title;
        this.description = description;
        this.priorityLevel = priorityLevel;
        this.completed = false;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPriorityLevel() {
        return priorityLevel;
    }
    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public void markAsCompleted() {

        this.completed = true;
    }
    public void updateTask(String title, String description, String priorityLevel) {

        this.title = title;

        this.description = description;

        this.priorityLevel = priorityLevel;
    }
    @Override
    public String toString() {
        return "Task: " + title + "\nDescription: " + description + "\nPriority: " + priorityLevel + "\nCompleted: " + completed;
    }
}
