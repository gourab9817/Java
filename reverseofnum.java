import java.util.*;

public class reverseofnum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number ");
        int number = sc.nextInt();
        int i = 0;
        int rev = 0;
        while (i < number) {
            int lastdigit = number % 10;
            rev = (rev * 10) + lastdigit;
            number = number / 10;

        }
        System.out.println(rev);
    }
}