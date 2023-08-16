import java.util.Scanner;

public class print_largest_among_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number ");
        int a = sc.nextInt();
        System.out.println("Enter the Second number ");

        int b = sc.nextInt();
        System.out.println("Enter the third number ");

        int c = sc.nextInt();
        if (a >= b && a >= c) {
            System.out.println("First input is the lagest among three");
        } else if (b >= c) {
            System.out.println("Second input is the lagest among three");

        } else {
            System.out.println("Third input is the lagest among three");
        }
    }
}
