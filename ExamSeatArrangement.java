import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ExamSeatArrangement {

    private int rows;
    private int cols;

    public ExamSeatArrangement(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public List<int[]> findUniqueSeatArrangements() {
        List<int[]> arrangements = new ArrayList<>();
        int[] colsFilled = new int[cols];

        // Helper function to recursively explore possible seatings
        findArrangementsHelper(colsFilled, 0, arrangements);

        return arrangements;
    }

    private void findArrangementsHelper(int[] colsFilled, int col, List<int[]> arrangements) {
        if (col == cols) {
            arrangements.add(colsFilled.clone());
            return;
        }

        for (int row = 0; row < rows; row++) {
            if (isValidSeat(row, col, colsFilled)) {
                colsFilled[col] = row;
                findArrangementsHelper(colsFilled, col + 1, arrangements);
                colsFilled[col] = 0; // Backtrack and explore other options
            }
        }
    }

    private boolean isValidSeat(int row, int col, int[] colsFilled) {
        // Check if same row, column, or diagonal has another student
        for (int c = 0; c < col; c++) {
            if (colsFilled[c] == row || Math.abs(row - colsFilled[c]) == Math.abs(col - c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int rows, cols;

        // Input validation loop
        do {
            System.out.print("Enter number of rows: ");
            rows = InputUtils.readInt();
        } while (rows <= 0);

        do {
            System.out.print("Enter number of columns: ");
            cols = InputUtils.readInt();
        } while (cols <= 0);

        ExamSeatArrangement arranger = new ExamSeatArrangement(rows, cols);
        List<int[]> arrangements = arranger.findUniqueSeatArrangements();

        System.out.println("Unique seat arrangements:");
        for (int[] arrangement : arrangements) {
            System.out.print("[");
            for (int i = 0; i < cols; i++) {
                int linearIndex = arrangement[i] * cols + i + 1; // Calculate linear index
                System.out.print(linearIndex);
                if (i < cols - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

        System.out.println("Total number of arrangements: " + arrangements.size());
    }
}

class InputUtils {
    public static int readInt() {
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                value = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        return value;
    }
}
