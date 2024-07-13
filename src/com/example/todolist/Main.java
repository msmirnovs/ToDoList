package com.example.todolist;

import java.util.Scanner;

public class Main {
    private static TaskManager taskManager = new TaskManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    completeTask();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nTo-Do List Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Remove Task");
        System.out.println("4. Complete Task");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        taskManager.addTask(description);
        System.out.println("Task added.");
    }

    private static void viewTasks() {
        System.out.println("\nAll Tasks:");
        int index = 1;
        for (Task task : taskManager.getTasks()) {
            System.out.println(index++ + ". " + task);
        }
    }

    private static void removeTask() {
        System.out.print("Enter task number to remove: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        taskManager.removeTask(index);
        System.out.println("Task removed.");
    }

    private static void completeTask() {
        System.out.print("Enter task number to complete: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        taskManager.completeTask(index);
        System.out.println("Task marked as complete.");
    }
}
