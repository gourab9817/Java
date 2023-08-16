import java.util.Scanner;

public class incometax_calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your total income");
        double income = sc.nextInt();
        if (income < 500000) {
            System.out.println("You have to paid tax 0 Rs");

        } else if (income > 500000 && income < 1000000) {
            double tax = income * (0.2);
            System.out.println("The paideble tax is" + tax);

        } else {
            double tax = income * 0.3;
            System.out.println("your tax is" + tax);
        }

    }
}
