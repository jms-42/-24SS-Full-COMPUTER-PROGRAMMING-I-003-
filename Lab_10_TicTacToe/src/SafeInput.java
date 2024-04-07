import java.util.Scanner;

public class SafeInput {


    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner pipe, String prompt) {
        int userInt = 0;
        boolean isValidInput = false;

        do {
            System.out.print(prompt);

            if (pipe.hasNextInt()) {
                userInt = pipe.nextInt();
                isValidInput = true;
            } else {
                pipe.next();
                System.out.println("Invalid input. Please enter a valid integer.");
            }
            pipe.nextLine();

        } while (!isValidInput);

        return userInt;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double userDouble = 0.0;
        boolean isValidInput = false;

        do {
            System.out.print(prompt);

            if (pipe.hasNextDouble()) {
                userDouble = pipe.nextDouble();
                isValidInput = true;
            } else {
                pipe.next();
                System.out.println("Invalid input. Please enter a valid double value.");
            }

            pipe.nextLine();

        } while (!isValidInput);

        return userDouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int userInt = 0;
        boolean isValidInput = false;

        do {
            System.out.print(prompt);

            if (pipe.hasNextInt()) {
                userInt = pipe.nextInt();

                if (userInt >= low && userInt <= high) {
                    isValidInput = true;
                } else {
                    System.out.println("Input out of range. Please enter an integer between " + low + " and " + high + ".");
                }
            } else {
                pipe.next();
                System.out.println("Invalid input. Please enter a valid integer.");
            }

            pipe.nextLine();

        } while (!isValidInput);

        return userInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double userDouble = 0.0;
        boolean isValidInput = false;

        do {
            System.out.print(prompt);

            if (pipe.hasNextDouble()) {
                userDouble = pipe.nextDouble();

                if (userDouble >= low && userDouble <= high) {
                    isValidInput = true;
                } else {
                    System.out.println("Input out of range. Please enter a double between " + low + " and " + high + ".");
                }
            } else {
                pipe.next();
                System.out.println("Invalid input. Please enter a valid double.");
            }

            pipe.nextLine();

        } while (!isValidInput);

        return userDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean isValidInput = false;
        boolean userConfirmed = false;

        do {
            System.out.print(prompt);

            String userInput = pipe.next().trim().toLowerCase();

            if (userInput.equals("y")) {
                isValidInput = true;
                userConfirmed = true;
            } else if (userInput.equals("n")) {
                isValidInput = true;
                userConfirmed = false;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }

        } while (!isValidInput);

        return userConfirmed;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String userInput;

        do {
            System.out.print(prompt);
            userInput = pipe.nextLine().trim();

            if (!userInput.matches(regEx)) {
                System.out.println("Invalid input. Please enter a string matching the specified pattern.");
            }
        } while (!userInput.matches(regEx));

        return userInput;
    }

    public static void prettyHeader(String msg) {
        final int LINE_WIDTH = 60;
        final int STAR_WIDTH = 3;

        for (int i = 0; i < LINE_WIDTH; i++) {
            System.out.print("*");
        }
        System.out.println();

        int padding = (LINE_WIDTH - msg.length() - (2 * STAR_WIDTH)) / 2;
        System.out.print("***");
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        if (msg.length() % 2 != 0) {
            System.out.print(" ");
        }
        System.out.println("***");

        for (int i = 0; i < LINE_WIDTH; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
