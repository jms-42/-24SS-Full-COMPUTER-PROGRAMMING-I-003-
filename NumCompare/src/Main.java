import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        // create the scanner object
        Scanner in = new Scanner(System.in);
        // output "Enter the first number: "
        System.out.print("Enter the first number: ");
        if (in.hasNextDouble()) {
            // input num1
            double num1 = in.nextDouble();
            System.out.print("Enter the second number: ");
            if (in.hasNextDouble()) {
                // input num2
                double num2 = in.nextDouble();
                // if(num1 =num2)
                if (num1 == num2) {
                    // output "The numbers are equal."
                    System.out.println("The numbers are equal.");
                }
                // else
                else {
                    // output "The numbers are equal."
                    System.out.println("The numbers are not equal.");
                    // minNumber=min(num1,num2)
                    double minNumber = Math.min(num1, num2);
                    // output "The smaller number is: ",minNumber
                    System.out.println("The smaller number is: " + minNumber);
                }
                // end if
                in.close();
            }
            else
            {
                // output "Error! Invalid input,please try again."
                System.out.println("Error! Invalid input,please try again. ");
            }
        }
        else
        {
            // output "Error! Invalid input,please try again. "
            System.out.println("Error! Invalid input,please try again. ");
        }
    }

}


