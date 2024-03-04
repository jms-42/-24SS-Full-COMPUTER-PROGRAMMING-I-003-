import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char playAgain;

        do {
            String playerAMove = getPlayerMove(in, "Player A");

            String playerBMove = getPlayerMove(in, "Player B");

            displayResults(playerAMove, playerBMove);

            do {
                System.out.print("Do you want to play again? (Y/N): ");
                playAgain = Character.toUpperCase(in.next().charAt(0));

                if (!Character.toString(playAgain).equalsIgnoreCase("Y") && !Character.toString(playAgain).equalsIgnoreCase("N")) {
                    System.out.println("Invalid input. Please enter Y or N.");
                }

            } while (!Character.toString(playAgain).equalsIgnoreCase("Y") && !Character.toString(playAgain).equalsIgnoreCase("N"));

        } while (Character.toString(playAgain).equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing!");
        in.close();
    }
    private static String getPlayerMove(Scanner scanner, String playerName) {
        String move;
        do {
            System.out.print(playerName + ", enter your move (R/r, P/p, or S/s): ");
            move = scanner.next().toUpperCase();

            if (!move.equals("R") && !move.equals("P") && !move.equals("S")) {
                System.out.println("Invalid move!....... Please enter R/r, P/p, or S/s.");
            }

        } while (!move.equals("R") && !move.equals("P") && !move.equals("S"));

        return move;
    }

    private static void displayResults(String moveA, String moveB) {
        System.out.println("Player A chose " + moveA+" and Player B chose " + moveB);

        if (moveA.equals("R") && moveB.equals("R")) {
            System.out.println("Rock vs Rock .....It's a Tie!");
        } else if (moveA.equals("S") && moveB.equals("S")) {
            System.out.println("Scissors vs Scissors .....It's a Tie!");
        } else if (moveA.equals("P") && moveB.equals("P")) {
            System.out.println("Paper vs Paper .....It's a Tie!");
        } else if (moveA.equals("R") && moveB.equals("S")) {
            System.out.println("Rock breaks Scissors......Player A wins!.... ");
        } else if (moveA.equals("P") && moveB.equals("R")) {
            System.out.println("Paper covers Rock......Player A wins!.... ");
        } else if (moveA.equals("S") && moveB.equals("P")) {
            System.out.println("Scissors cuts Paper......Player A wins!.... ");
        } else if (moveA.equals("S") && moveB.equals("R")) {
            System.out.println("Rock breaks Scissors......Player B wins!.... ");
        } else if (moveA.equals("R") && moveB.equals("P")) {
            System.out.println("Paper covers Rock.....Player B wins!.... ");
        } else if (moveA.equals("P") && moveB.equals("S")) {
            System.out.println("Scissors cuts Paper......Player B wins!.... ");
        } else {
            System.out.println("Enter valid input!");
        }
        System.out.println();
    }
}