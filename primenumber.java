import java.util.*;

public class primenumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        for (int i = 2; i < number - 1; i++) {
            if (number % i == 0) {
                System.out.println(number + " is not a prime number");

                break;
            } else {
                System.out.println(number + "is a prime number");
                break;
            }

        }
    }

}
