import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static final ArrayList<String> itemList = new ArrayList<>();
    private static final String INPUT_REGEX = "[AaDdPpQqOoSsCcVv]";
    private static final String CHOICES = "A - Add an item to the list\n" +
            "D - Delete an item from the list\n" +
            "V - View the list\n" +
            "O - Open a list file from disk\n" +
            "S - Save the current list file to disk\n" +
            "C - Clear the current list\n" +
            "Q - Quit the program";

    private static boolean needsToBeSaved = false;

    public static void main(String[] args) {
        char choice;

        do {
            displayMenu();
            choice = SafeInput.getRegExString(in, "Enter your choice: ", INPUT_REGEX).toUpperCase().charAt(0);
            switch (choice) {
                case 'A':
                    addItem();
                    break;
                case 'D':
                    deleteItem();
                    break;
                case 'V':
                    printList();
                    break;
                case 'O':
                    openList();
                    break;
                case 'S':
                    saveList();
                    break;
                case 'C':
                    clearList();
                    break;
                case 'Q':
                    quitProgram();
                    break;
            }
        } while (choice != 'Q');
    }

    private static void displayMenu() {
        System.out.println("Options:");
        System.out.println(CHOICES);
    }

    private static void addItem() {
        String item = SafeInput.getRegExString(in, "Enter the item to add in list: ", ".+");
        itemList.add(item);
        needsToBeSaved = true;
        System.out.println("Item added to the list successfully.");
    }

    private static void deleteItem() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        System.out.println("Current list:");
        printList();
        int min = 1;
        int max = itemList.size();

        int index = SafeInput.getRangedInt(in, "Enter the number of the item to delete between " + min + " and " + max + ": ", min, max);
        if (index != -1) {
            itemList.remove(index - 1);
            needsToBeSaved = true;
            System.out.println("Item deleted from the list.");
        }
    }

    private static void printList() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (int i = 0; i < itemList.size(); i++) {
                System.out.println((i + 1) + ". " + itemList.get(i));
            }
        }
    }

    private static void openList() {
        if (needsToBeSaved) {
            if (SafeInput.getYNConfirm(in, "Save current list before loading a new one? (Y/N): ")) {
                saveList();
            }
        }
        String fileName = SafeInput.getRegExString(in, "Enter the file name to load with (.txt extension): ", ".+\\.txt");

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            itemList.clear();
            itemList.addAll(lines);
            needsToBeSaved = false;
            System.out.println("List loaded from file: " + fileName);
        } catch (Exception e) {
            System.out.println("Error loading the list from file: " + e.getMessage());
        }
    }

    private static void saveList() {
        if (itemList.isEmpty()) {
            System.out.println("Cannot save an empty list.");
            return;
        }

        String fileName = SafeInput.getRegExString(in, "Enter the file name to save with (.txt extension): ", ".+\\.txt");

        try {
            Files.write(Paths.get(fileName), itemList);
            needsToBeSaved = false;
            System.out.println("List saved to the file: " + fileName);
        } catch (Exception e) {
            System.out.println("Error saving the list to the file: " + e.getMessage());
        }
    }

    private static void clearList() {
        if (itemList.isEmpty()) {
            System.out.println("The list is already empty.");
            return;
        }

        if (SafeInput.getYNConfirm(in, "Are you sure you want to clear the current list? (Y/N): ")) {
            itemList.clear();
            needsToBeSaved = true;
            System.out.println("Current list cleared.");
        } else {
            System.out.println("Operation canceled. The current list was not cleared.");
        }
    }


    private static void quitProgram() {
        if (needsToBeSaved) {
            if (SafeInput.getYNConfirm(in, "Save current list before quitting? (Y/N): ")) {
                saveList();
            }
        }

        System.out.println("Exiting program.");
        System.exit(0);
    }
}
