package ToDoList;
import java.util.*;

public class Main {
    private static List<Task> tasks = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    private static void printMenu() {
        System.out.println("\nToDo List Manager");
        System.out.println("[1] - Add new task");
        System.out.println("[2] - Complete task");
        System.out.println("[3] - Delete task");
        System.out.println("[4] - View task");
        System.out.println("[5] - Exit program");
        System.out.print("Enter your choice: ");
    }

    private static void addTask() {
        System.out.print("\nEnter Task Description: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task added successfully!");
    }

    private static void completeTask() {
        viewTask();
        System.out.print("\nEnter the index of the task to mark as completed: ");
        int index = scanner.nextInt();
        if (index >= 0 && index <= tasks.size()) {
            Task task = tasks.get(index);
            task.setCompleted(true);
            System.out.println("Task marked as completed: " + task.getDescription());
        } else {
            System.err.println("Invalid index. Please try again.");
        }
    }

    private static int removedIndex = -1;
    private static void deleteTask() {
        viewTask();
        System.out.print("\nEnter the index of the task to remove: ");
        int index = scanner.nextInt();
        if (index >= 0 && index <= tasks.size()) {
            Task removedTask = tasks.get(index);
            removedIndex = index;
            System.out.println("Task removed: " + removedTask.getDescription());
        } else {
            System.err.println("Invalid index. Please try again.");
        }
    }

    private static void viewTask() {
        System.out.println("\nTasks:");
        for (int j = 0; j < tasks.size(); j++) {
            Task task = tasks.get(j);
            if (j != removedIndex) {
                System.out.println(j + ". " + task.getDescription() + (task.isCompleted() ? " - [Completed]" : ""));
            }
        }

        if (tasks.isEmpty()) {
            System.out.println("No task found.");
        }

    }

    private static class Task {
        private String description;
        private boolean completed;

        public Task(String description) {
            this.description = description;
            this.completed = false;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }
    }

    public static void main(String[] args) {

        boolean isRunning = true;
        while (isRunning) {
            printMenu();
            int choice =  scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    completeTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    viewTask();
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("\nExiting ToDo List Manager... Thank you & Goodbye!");
                    break;
                default:
                    System.err.println("Invalid Entry");
                    break;
            }
        }
    }
}