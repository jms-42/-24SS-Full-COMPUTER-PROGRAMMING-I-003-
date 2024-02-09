import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create the scanner object
        Scanner in = new Scanner(System.in);
        // output "Choose your party affiliation:"
        System.out.println("Choose your party affiliation:");
        // output "D - Democrat"
        System.out.println("D - Democrat");
        // output "R - Republican"
        System.out.println("R - Republican");
        // output "I - Independent"
        System.out.println("I - Independent");
        // output "Enter your choice: "
        System.out.print("Enter your choice: ");
        String userChoice = in.next().toUpperCase();
        // input userChoice
        System.out.println(userChoice);

        // if userInput="D"
        if(userChoice.equals("D"))
        {
            // output "You get a Democratic Donkey."
            System.out.println("You get a Democratic Donkey.");
        }
        //  else if userInput="R"
        else if (userChoice.equals("R"))
        {
            // output "You get a Republican Elephant."
            System.out.println("You get a Republican Elephant.");
        }
        // else if userInput="I"
        else if (userChoice.equals("I"))
        {
            // output "You get an Independent Person."
            System.out.println("You get an Independent Person.");
        }
        else {
            // output "You get an Other."
            System.out.println("You get an Other.");
        }
        // end if
        in.close();
    }
}
