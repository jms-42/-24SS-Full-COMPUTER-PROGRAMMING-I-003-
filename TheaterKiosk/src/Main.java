import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // create the scanner object
        Scanner in = new Scanner(System.in);
        // output "Enter your age: "
        System.out.println("Enter your age: ");
        // input age
        if (in.hasNextInt())
        {
            int age = in.nextInt();
            // if age >=21
            if (age >= 21)
            {
                // output "Congratulations! You get a2 wristband."
                System.out.println("Congratulations! You get a wristband.");
            }
            //else
            else
            {
                // output "Sorry, you are not eligible for a wristband."
                System.out.println("Sorry, you are not eligible for a wristband.");
            }
            // end if
        }
        else {
            // output "Invalid input. Please enter a valid age as an integer."
            System.out.println("Invalid input. Please enter a valid age as an integer.");
        }

        in.close();
    }
}
