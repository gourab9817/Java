import java.util.*;

class JugState {
    int x, y;

    JugState(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        JugState jugState = (JugState) o;
        return x == jugState.x && y == jugState.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class WaterJugProblem {

    private static List<JugState> solveWaterJugProblem(int X, int Y, int m) {
        Set<JugState> visited = new HashSet<>();
        Queue<List<JugState>> queue = new LinkedList<>();
        List<JugState> startPath = new ArrayList<>();
        startPath.add(new JugState(0, 0));
        queue.add(startPath);

        while (!queue.isEmpty()) {
            List<JugState> path = queue.poll();
            JugState currentState = path.get(path.size() - 1);

            if (visited.contains(currentState)) {
                continue;
            }
            visited.add(currentState);

            if (currentState.x == m) {
                return path;
            }

            List<JugState> nextStates = getNextStates(currentState, X, Y);

            for (JugState state : nextStates) {
                if (!visited.contains(state)) {
                    List<JugState> newPath = new ArrayList<>(path);
                    newPath.add(state);
                    queue.add(newPath);
                }
            }
        }

        return null;
    }

    private static List<JugState> getNextStates(JugState state, int X, int Y) {
        List<JugState> nextStates = new ArrayList<>();
        // Fill Jug X
        nextStates.add(new JugState(X, state.y));
        // Fill Jug Y
        nextStates.add(new JugState(state.x, Y));
        // Empty Jug X
        nextStates.add(new JugState(0, state.y));
        // Empty Jug Y
        nextStates.add(new JugState(state.x, 0));
        // Transfer X to Y
        int transferToY = Math.min(state.x, Y - state.y);
        nextStates.add(new JugState(state.x - transferToY, state.y + transferToY));
        // Transfer Y to X
        int transferToX = Math.min(state.y, X - state.x);
        nextStates.add(new JugState(state.x + transferToX, state.y - transferToX));

        return nextStates;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter capacity of Jug X: ");
        int X = scanner.nextInt();
        System.out.println("Enter capacity of Jug Y: ");
        int Y = scanner.nextInt();
        System.out.println("Enter the target amount of water in Jug X: ");
        int m = scanner.nextInt();

        List<JugState> solution = solveWaterJugProblem(X, Y, m);
        if (solution != null) {
            System.out.println("Solution found:");
            for (JugState state : solution) {
                System.out.println("Jug X: " + state.x + "L, Jug Y: " + state.y + "L");
            }
        } else {
            System.out.println("No solution exists.");
        }
    }
}