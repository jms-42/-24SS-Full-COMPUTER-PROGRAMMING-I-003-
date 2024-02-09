import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create the scanner object
        Scanner in = new Scanner(System.in);
        // output "Enter your birth month between (1-12): "
        System.out.println("Enter your birth month between (1-12): ");
        if (in.hasNextInt())
        {
            // input birthMonth
            int birthMonth = in.nextInt();
           // if month >=1 and month<= 12
            if (birthMonth >= 1 && birthMonth <= 12)
            {
               // output "Your birth month is: " , birthMonth
                System.out.println("Your birth month is: " + birthMonth);
            }
            else
            {
                // output "You entered an incorrect month value: " , birthMonth
                System.out.println("You entered an incorrect month value: " + birthMonth);
            }
            // end if
        }
        else
        {
            // output "Invalid input. Please enter a valid integer."
            System.out.println("Invalid input. Please enter a valid integer.");
        }
        in.close();
    }
}
