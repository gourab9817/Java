import java.util.*;

public class multipleof10until_break {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 1;
        while (true) {
            System.out.println("Enter the number ");
            int number = sc.nextInt();
            if (number % 10 == 0) {
                break;
            }
            System.out.println("Its not a multiple of 10");
            i++;
        }
        System.out.println("It is a multiple of 10");

    }
}
