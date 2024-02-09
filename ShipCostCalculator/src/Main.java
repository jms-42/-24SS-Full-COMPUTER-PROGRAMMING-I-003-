import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create the scanner object
        Scanner in = new Scanner(System.in);
        // output "Enter the price of an item: $"
        System.out.println("Enter the price of an item: $");
        // input doubleItemPrice
        double doubleItemPrice = in.nextDouble();
        double shippingCost;
       // if doubleItemPrice >= 100
        if(doubleItemPrice >= 100)
        {
           // shippingCost=0
            shippingCost=0;
        }
        // else
        else {
           // shippingCost = 0.02 * doubleItemPrice
            shippingCost=(2*doubleItemPrice)/100;
        }
        // end if
        // totalPrice = doubleItemPrice + shippingCost
        double totalPrice = doubleItemPrice + shippingCost;
        // output "Shipping Cost: $ ", shippingCost
        System.out.println("Shipping Cost: $ "+ shippingCost);
        //output "Total Price: $ ", totalPrice
        System.out.println("Total Price: $ "+ totalPrice);

        in.close();

    }
}
