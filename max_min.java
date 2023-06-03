
//Java programs for finding max terms and min terms in array by taking user input
import java.util.*;

public class max_min {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the elements for the array");
            arr[i] = sc.nextInt();

        }
        for (int j = 0; j < n; j++) {
            System.out.println(arr[j]);
        }

        Arrays.sort(arr);
        System.out.println("The sorteed array is");
        for (int j = 0; j < n; j++) {
            System.out.println(arr[j]);
        }
        System.out.println("The max term is ");
        System.out.println(arr[n - 1]);
        System.out.println("The min term is ");
        System.out.println(arr[0]);

    }
}