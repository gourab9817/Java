import java.util.*;

public class print1ton {
    public static void main(String[] args) {
        System.out.println("Enter the range ");
        Scanner sc = new Scanner(System.in);
        int range = sc.nextInt();
        int i = 0;
        while (i <= range) {
            System.out.println(i);
            i = i + 1;
        }
    }

}
