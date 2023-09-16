import java.util.*;

public class sum_of_n_numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range ");
        int range = sc.nextInt();
        int i = 0, sum = 0;
        while (i <= range) {
            sum = sum + i;
            i++;

        }
        System.out.println("The sum upto provided range is " + sum);
    }
}
