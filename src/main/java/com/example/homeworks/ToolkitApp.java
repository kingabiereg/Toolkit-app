package com.example.homeworks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ToolkitApp {
    private static final int SHOW_ALL = 1;
    private static final int FIND_TOOL = 2;
    private static final int ADD_TOOL = 3;
    private static final int COUNT_TOOL = 4;
    private static final int EXIT = 0;

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ToolkitRepository toolkitRepository = new ToolkitRepository();
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;
        while (isRunning) {
            showOptions();
            try {
                int selectedOption = readOption(scanner);

                switch (selectedOption) {
                    case SHOW_ALL -> showAll(toolkitRepository);
                    case FIND_TOOL -> findTool(toolkitRepository);
                    case ADD_TOOL -> addTool(toolkitRepository);
                    case COUNT_TOOL -> countTools(toolkitRepository);
                    case EXIT -> isRunning = false;
                    default -> System.out.println("Unexpected value");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid value. Enter a number");
                scanner.next();
            }
        }
    }

    private static void showOptions() {
        System.out.println("Menu options\n"
                + SHOW_ALL + " - show all tools\n"
                + FIND_TOOL + " - find tool by name\n"
                + ADD_TOOL + " - add new tool\n"
                + COUNT_TOOL + " - count found tool\n"
                + EXIT + " - exit");
    }

    private static int readOption(Scanner scanner) {
        return scanner.nextInt();
    }

    private static void showAll(ToolkitRepository toolkitRepository) {
        if (toolkitRepository.isEmpty()) {
            System.out.println("You have no tools in your toolkit");
            return;
        }
        toolkitRepository.getTools().forEach(ToolkitApp::showTool);
        System.out.println("---");
    }

    private static void showTool(Tool tool) {
        System.out.println("---\n" + tool.getName()
                + "\nSize: " + tool.getToolSize().size() + " " + tool.getToolSize().unit());
    }

    private static void findTool(ToolkitRepository toolkitController) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a tool name: ");
        String findTool = scanner.nextLine().toLowerCase();

        if (toolkitController.getTools().stream()
                .anyMatch(tool -> tool.getName().contains(findTool))) {
            System.out.println("There is a " + findTool + " in toolkit.");

            (toolkitController.getTools().stream()
                    .filter(tool -> tool.getName().contains(findTool)))
                    .forEach(ToolkitApp::showTool);
        } else {
            System.out.println("Sorry, there is not a " + findTool + " in toolkit.");
        }
    }

    private static void addTool(ToolkitRepository toolkitController) {

        Scanner scanner = new Scanner(System.in);
        String name = " ";
        String unit = " ";
        Float size = 0.0f;
        System.out.println("Write a tool name:");

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.isBlank()) {
                System.out.println("This area cannot be empty!\nEnter a tool name again:");
            } else {
                name = input;
                break;
            }
        }
        System.out.println("Write a size: ");
        while (scanner.hasNext()) {
            try {
                float input2 = scanner.nextFloat();
                if (input2 <= 0) {
                    System.out.println("Enter a size again:");
                } else {
                    size = input2;
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("This area must contain only numbers!\nEnter a size again:");
                scanner.next();
            }
        }
        scanner.nextLine();
        System.out.println("Write a unit: ");
        while (scanner.hasNextLine()) {
            String input3 = scanner.nextLine();
            if (!input3.matches("[a-zA-Z]+")) {
                System.out.println("This area must contain only letters!\nEnter a unit again:");
            } else if (input3.isEmpty()) {
                System.out.println("This area cannot be empty");
            } else {
                unit = input3;
                break;
            }
        }

        Tool tool = new Tool(name, new Tool.ToolSize(size, unit));
        toolkitController.add(tool);

        System.out.println("Succesfully added:\n" + tool.getName()
                + "\nsize: " + tool.getToolSize().size() + " " + tool.getToolSize().unit());
    }

    private static void countTools(ToolkitRepository toolkitController) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a tool name: ");
        String findTool = scanner.nextLine().toLowerCase();

        long countTools = toolkitController.getTools().stream().filter(tool -> tool.getName().contains(findTool)).count();
        System.out.println("There are " + countTools + " " + findTool + " " + "in toolkit");

    }
}
