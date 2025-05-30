import java.util.*;

public class Check_if_it_is_possible_to_finish_all_task_from_given_dependencies{

    // Pair class for prerequisite representation
    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // Construct graph from prerequisites
    static ArrayList<ArrayList<Integer>> makeGraph(int numTasks, Vector<Pair> prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numTasks; i++) {
            graph.add(new ArrayList<>());
        }

        for (Pair pre : prerequisites) {
            graph.get(pre.second).add(pre.first); // edge from pre.second to pre.first
        }

        return graph;
    }

    // DFS to detect cycle
    static boolean dfsCycle(ArrayList<ArrayList<Integer>> graph, int node, boolean[] onPath, boolean[] visited) {
        if (visited[node]) return false;

        onPath[node] = visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (onPath[neighbor] || dfsCycle(graph, neighbor, onPath, visited))
                return true;
        }

        onPath[node] = false;
        return false;
    }

    // Check if it's possible to finish all tasks
    static boolean canFinish(int numTasks, Vector<Pair> prerequisites) {
        ArrayList<ArrayList<Integer>> graph = makeGraph(numTasks, prerequisites);
        boolean[] visited = new boolean[numTasks];
        boolean[] onPath = new boolean[numTasks];

        for (int i = 0; i < numTasks; i++) {
            if (!visited[i] && dfsCycle(graph, i, onPath, visited)) {
                return false; // cycle found
            }
        }

        return true; // no cycle
    }

    // Main method
    public static void main(String[] args) {
        int numTasks = 4;
        Vector<Pair> prerequisites = new Vector<>();

        // Example: [1, 0], [2, 1], [3, 2]
        prerequisites.add(new Pair(1, 0));
        prerequisites.add(new Pair(2, 1));
        prerequisites.add(new Pair(3, 2));

        if (canFinish(numTasks, prerequisites)) {
            System.out.println("Possible to finish all tasks");
        } else {
            System.out.println("Impossible to finish all tasks");
        }
    }
}
