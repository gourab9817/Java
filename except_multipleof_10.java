import java.util.*;

public class except_multipleof_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 1;
        while (true) {
            System.out.print("Enter the number ");
            int number = sc.nextInt();
            if (number % 10 == 0) {
                continue;

            }
            System.out.println(number + " is valid");
            i++;
        }

    }
}
