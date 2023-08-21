import java.util.*;

public class calculator_using_switch_keys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a first digit");
        double a = sc.nextDouble();
        System.out.println("Enter the second digit");
        double b = sc.nextDouble();
        System.out.println("Enter the operation you want + - * / % between those digits ");
        char operation = sc.next().charAt(0);
        switch (operation) {
            case '+':
                System.out.println("The result is " + (a + b));
                break;
            case '-':
                System.out.println("The result is " + (a - b));
                break;
            case '*':
                System.out.println("The result is " + a * b);
                break;
            case '/':
                System.out.println("The result is " + a / b);
                break;
            case '%':
                System.out.println("The result is " + a % b);
                break;

            default:
                System.out.println("Enter a valid key");

        }
    }
}
