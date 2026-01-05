package week8;

import java.util.*;

class Task {
    int id;
    String title;
    boolean completed;

    Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.completed = false;
    }
}

class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private List<Task> highPriorityTasks = new Vector<>();
    private int nextId = 1;

    void addTask(String title, boolean highPriority) {
        Task newTask = new Task(nextId, title);
        tasks.add(newTask);
        if (highPriority) {
            highPriorityTasks.add(newTask);
        }
        System.out.println("Task added: " + title + " (ID: " + nextId + ")");
        nextId++;
    }

    void removeTask(int id) {
        tasks.removeIf(task -> task.id == id);
        highPriorityTasks.removeIf(task -> task.id == id);
        System.out.println("Task removed: " + id);
    }

    void markCompleted(int id) {
        for (Task task : tasks) {
            if (task.id == id) {
                task.completed = true;
                System.out.println("Task completed: " + id);
                return;
            }
        }
        System.out.println("Task not found.");
    }

    void displayTasks() {
        System.out.println("Task List:");
        for (Task task : tasks) {
            System.out.println("ID: " + task.id + " | " + task.title + " | " + (task.completed ? "Completed" : "Pending"));
        }
    }

    void displayHighPriorityTasks() {
        System.out.println("High Priority Task List:");
        for (Task task : highPriorityTasks) {
            System.out.println("ID: " + task.id + " | " + task.title + " | " + (task.completed ? "Completed" : "Pending"));
        }
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        
        manager.addTask("Complete project", true);
        manager.addTask("Buy groceries", false);
        
        System.out.println("\nAll Tasks:");
        manager.displayTasks();
        
        System.out.println("\nHigh Priority Tasks:");
        manager.displayHighPriorityTasks();
        
        manager.markCompleted(1);
        
        System.out.println("\nAfter marking task 1 as completed:");
        manager.displayTasks();
        
        manager.removeTask(2);
        
        System.out.println("\nAfter removing task 2:");
        manager.displayTasks();
    }
}
