import java.util.Scanner;

public class ternery_operators {
    public static void main(String[] args) {
        // ternery operators
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an Integer");
        int a = sc.nextInt();
        String b = ((a % 2) == 0) ? "True" : "False";
        System.out.println(b + "! It is not divisiable by 2");
    }
}
