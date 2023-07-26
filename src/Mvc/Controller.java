package Mvc;
import java.util.List;
import java.util.Scanner;
public class Controller {
	private View taskManager; 
    private Scanner scanner;
    public Controller(View taskManager) {
        this.taskManager = taskManager;
        this.scanner = new Scanner(System.in);
    }
    public void displayMenu() {
        System.out.println("===== Task Manager =====");
        System.out.println("1. Create a new task");
        System.out.println("2. View task list");
        System.out.println("3. Update task details");
        System.out.println("4. Mark task as complete");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    public void run() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    createTask();
                    break;
                case 2:
                    viewTaskList();
                    break;
                case 3:
                    updateTaskDetails();
                    break;
                case 4:
                    markTaskAsComplete();
                    break;
                case 0:
                    System.out.println("Exiting Task Manager...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        } while (choice != 0);
    }
    private void createTask() {
        System.out.println("===== Create a New Task =====");
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the description: ");
        String description = scanner.nextLine();
        System.out.print("Enter the priority level: ");
        String priorityLevel = scanner.nextLine();
        taskManager.createTask(title, description, priorityLevel);
        System.out.println("New task created successfully!");
    }
    private void viewTaskList() {
        System.out.println("===== Task List =====");
        List<Model> tasks = taskManager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                Model task = tasks.get(i);
                System.out.println("Task #" + (i + 1));
                System.out.println("Title: " + task.getTitle());
                System.out.println("Priority: " + task.getPriorityLevel());
                System.out.println("Completed: " + (task.isCompleted() ? "Yes" : "No"));
                System.out.println("--------------------");
            }
        }
    }
    private void updateTaskDetails() {
        System.out.println("===== Update Task Details =====");
        List<Model> tasks = taskManager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            viewTaskList();
            System.out.print("Enter the task number to update: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                Model task = tasks.get(taskNumber - 1);
                System.out.print("Enter the new title: ");
                String title = scanner.nextLine();
                System.out.print("Enter the new description: ");
                String description = scanner.nextLine();
                System.out.print("Enter the new priority level: ");
                String priorityLevel = scanner.nextLine();
                taskManager.updateTaskDetails(taskNumber - 1, title, description, priorityLevel);
                System.out.println("Task details updated successfully!");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
    private void markTaskAsComplete() {
        System.out.println("===== Mark Task as Complete =====");
        List<Model> tasks = taskManager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            viewTaskList();
            System.out.print("Enter the task number to mark as complete: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                Model task = tasks.get(taskNumber - 1);
                if (!task.isCompleted()) {
                    taskManager.markTaskAsComplete(taskNumber - 1);
                    System.out.println("Task marked as complete!");
                } else {
                    System.out.println("Task is already marked as complete.");
                }
            } else {

                System.out.println("Invalid task number.");
            }
        }
    }
    public static void main(String[] args) {
        View taskManager = new View();
        Controller taskView = new Controller(taskManager);
        taskView.run();
}
}
