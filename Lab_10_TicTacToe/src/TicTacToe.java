import java.util.Scanner;

public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];
    private static String currentPlayer = "X";

    public static void main(String[] args) {
        clearBoard();

        while (true) {
            display();
            int[] move = getPlayerMove();
            int row = move[0];
            int col = move[1];

            if (!isValidMove(row, col)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board[row][col] = currentPlayer;

            if (isWin(currentPlayer)) {
                display();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (isTie()) {
                display();
                System.out.println("It's a tie!");
                break;
            }

            togglePlayer();
        }
    }

    private static void clearBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void display() {
        System.out.println("-------------");
        for (int i = 0; i < ROW; i++) {
            System.out.print("| ");
            for (int j = 0; j < COL; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static int[] getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");

            while (!scanner.hasNextInt()) {
                System.out.println("Error: Invalid input. Please enter a valid input for row (1-3).");
                scanner.next();
            }
            row = scanner.nextInt() - 1;

            while (!scanner.hasNextInt()) {
                System.out.println("Error: Invalid input. Please enter a valid input for column(1-3).");
                scanner.next();
            }
            col = scanner.nextInt() - 1;

            if (isValidMove(row, col)) {
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        return new int[]{row, col};
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROW; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int j = 0; j < COL; j++) {
            if (board[0][j].equals(player) && board[1][j].equals(player) && board[2][j].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(" ")) {
                    return false; // There is an empty cell, game is not a tie yet
                }
            }
        }
        return true; // All cells are filled, it's a tie
    }

    private static void togglePlayer() {
        currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
    }
}