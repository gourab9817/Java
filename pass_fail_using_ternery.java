import java.util.Scanner;

public class pass_fail_using_ternery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your marks ");
        int a = sc.nextInt();
        String status = (a > 33) ? "Pass " : "Fail";
        System.out.println("The student has " + status + " the exam");
    }
}
