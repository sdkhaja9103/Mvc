package Mvc;
import java.util.ArrayList;
import java.util.List;

public class View {
	private List<Model> tasks;
    public View() {
        tasks = new ArrayList<>();
    }
    public void createTask(String title, String description, String priorityLevel) {
        Model newTask = new Model(title, description, priorityLevel);
        tasks.add(newTask);
    }
    public void updateTaskDetails(int taskIndex, String title, String description, String priorityLevel) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Model task = tasks.get(taskIndex);
            task.updateTask(title, description, priorityLevel);
        }
    }
    public void markTaskAsComplete(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Model task = tasks.get(taskIndex);
            if (!task.isCompleted()) {
                task.markAsCompleted();
            }
        }
    }
    public List<Model> getAllTasks() {
        return tasks;
}
}
