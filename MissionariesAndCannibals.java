import java.util.Objects;
import java.util.Scanner;

public class MissionariesAndCannibals {

    private static final int MAX_DEPTH = 50; // Adjust as needed

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the number of missionaries: ");
            int missionaries = scanner.nextInt();
            System.out.print("Enter the number of cannibals: ");
            int cannibals = scanner.nextInt();

            State initialState = new State(missionaries, cannibals, 0, 0, 0);
            State goalState = new State(0, 0, missionaries, cannibals, 1);

            System.out.println("Initial State: " + initialState);
            System.out.println("Goal State: " + goalState);

            if (isSafe(initialState)) {
                System.out.println("Solution:");
                solve(initialState, goalState, 0);
            } else {
                System.out.println("Invalid initial state. The input configuration is not safe.");
            }
        } catch (Exception e) {
            System.out.println("Error reading input. Please enter valid integers.");
        } finally {
            scanner.close();
        }
    }

    static class State {
        int missionariesLeft, cannibalsLeft, missionariesRight, cannibalsRight, boat;

        State(int missionariesLeft, int cannibalsLeft, int missionariesRight, int cannibalsRight, int boat) {
            this.missionariesLeft = missionariesLeft;
            this.cannibalsLeft = cannibalsLeft;
            this.missionariesRight = missionariesRight;
            this.cannibalsRight = cannibalsRight;
            this.boat = boat;
        }

        @Override
        public String toString() {
            return "(" + missionariesLeft + "M, " + cannibalsLeft + "C, B" + boat + ", " +
                    missionariesRight + "M, " + cannibalsRight + "C)";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            State state = (State) obj;
            return missionariesLeft == state.missionariesLeft &&
                    cannibalsLeft == state.cannibalsLeft &&
                    missionariesRight == state.missionariesRight &&
                    cannibalsRight == state.cannibalsRight &&
                    boat == state.boat;
        }

        @Override
        public int hashCode() {
            return Objects.hash(missionariesLeft, cannibalsLeft, missionariesRight, cannibalsRight, boat);
        }
    }

    static boolean isValid(int missionaries, int cannibals) {
        return missionaries >= 0 && cannibals >= 0 && (missionaries == 0 || missionaries >= cannibals);
    }

    static boolean isSafe(State state) {
        return isValid(state.missionariesLeft, state.cannibalsLeft) &&
                isValid(state.missionariesRight, state.cannibalsRight);
    }

    static void solve(State currentState, State goalState, int depth) {
        if (depth > MAX_DEPTH) {
            System.out.println("Max depth reached. Exiting to avoid StackOverflowError.");
            return;
        }

        if (isSafe(currentState)) {
            System.out.println(currentState);
        }

        if (currentState.equals(goalState)) {
            return;
        }

        if (currentState.boat == 0) {
            for (int m = 0; m <= 2; m++) {
                for (int c = 0; c <= 2; c++) {
                    if (m + c >= 1 && m + c <= 2) {
                        State nextState = new State(
                                currentState.missionariesLeft - m,
                                currentState.cannibalsLeft - c,
                                currentState.missionariesRight + m,
                                currentState.cannibalsRight + c,
                                1);

                        solve(nextState, goalState, depth + 1);
                    }
                }
            }
        } else {
            for (int m = 0; m <= 2; m++) {
                for (int c = 0; c <= 2; c++) {
                    if (m + c >= 1 && m + c <= 2) {
                        State nextState = new State(
                                currentState.missionariesLeft + m,
                                currentState.cannibalsLeft + c,
                                currentState.missionariesRight - m,
                                currentState.cannibalsRight - c,
                                0);

                        solve(nextState, goalState, depth + 1);
                    }
                }
            }
        }
    }
}
