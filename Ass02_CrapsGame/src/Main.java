import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        String playAgain;

        do {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int crapsRoll = die1 + die2;

            System.out.println("Rolling the dice...");
            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println("Sum: " + crapsRoll);

            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                System.out.println("Craps! You crapped out. You lose!");
            } else if (crapsRoll == 7 || crapsRoll == 11) {
                System.out.println("Natural! You win!");
            } else {
                System.out.println("Point is set to " + crapsRoll);
                playSubsequentRolls(crapsRoll, rnd);
            }

            do {
                System.out.print("Do you want to play again? (Y/N): ");
                playAgain = scanner.next().toUpperCase();

                if (!playAgain.equals("Y") && !playAgain.equals("N")) {
                    System.out.println("Invalid input. Please enter Y or N.");
                }

            } while (!playAgain.equals("Y") && !playAgain.equals("N"));

        } while (playAgain.equals("Y"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }
    private static void playSubsequentRolls(int point, Random rnd) {
        int roll;
        boolean continueRolling = true;

        while (continueRolling) {
            roll = rnd.nextInt(6) + 1 + rnd.nextInt(6) + 1;
            System.out.println("Rolling the dice again...");
            System.out.println("Die 1: " + (rnd.nextInt(6) + 1));
            System.out.println("Die 2: " + (rnd.nextInt(6) + 1));
            System.out.println("Sum: " + roll);

            if (roll == point) {
                System.out.println("Made point! You win!");
                continueRolling = false;
            } else if (roll == 7) {
                System.out.println("Got a seven! You lose!");
                continueRolling = false;
            } else {
                System.out.println("Trying for point...");
            }
        }
    }
}