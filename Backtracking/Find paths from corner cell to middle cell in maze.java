import java.util.*;

public class GfG {

    // function to find a path from source to destination
    static void findPath(int x, int y, List<List<Integer>> path, 
    List<List<Integer>> visited, List<List<List<Integer>>> res, 
    int[][] mat) {
        int n = mat.length;

        // if (x, y) is out of bounds
        if (x < 0 || x >= n || y < 0 || y >= n)
            return;

        // if (x, y) is already visited
        if (visited.get(x).get(y) == 1)
            return;

        // mark (x, y) as visited
        visited.get(x).set(y, 1);

        // add (x, y) to path
        List<Integer> cell = new ArrayList<>();
        cell.add(x);
        cell.add(y);
        path.add(cell);

        // if (x, y) is the mid cell
        if (x == n / 2 && y == n / 2) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> p : path) {
                temp.add(new ArrayList<>(p));
            }
            res.add(temp);
            path.remove(path.size() - 1);
            visited.get(x).set(y, 0);
            return;
        }

        // search in all four directions
        int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        for (int i = 0; i < 4; ++i) {
            int u = x + dir[i][0] * mat[x][y];
            int v = y + dir[i][1] * mat[x][y];
            findPath(u, v, path, visited, res, mat);
        }

        // backtrack
        path.remove(path.size() - 1);
        visited.get(x).set(y, 0);
    }

    // Function to find a path from corner cell to
    // middle cell in mat containing positive numbers
    static List<List<List<Integer>>> findPathInMaze(int[][] mat) {
        int n = mat.length;

        // to store complete path
        // from source to destination
        List<List<List<Integer>>> res = new ArrayList<>();

        // to mark visited cells
        List<List<Integer>> visited = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            visited.add(row);
        }

        // corner cells
        int[][] corners = { {0, 0}, {0, n-1}, {n-1, 0}, {n-1, n-1} };

        // to store the path
        List<List<Integer>> path = new ArrayList<>();

        // Consider each corners as the starting
        // point and search in mat
        for (int i = 0; i < 4; ++i) {
            int x = corners[i][0];
            int y = corners[i][1];
            findPath(x, y, path, visited, res, mat);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {
            { 3, 5, 4, 4, 7, 3, 4, 6, 3 },
            { 6, 7, 5, 6, 6, 2, 6, 6, 2 },
            { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
            { 6, 5, 5, 1, 2, 3, 6, 5, 6 },
            { 3, 3, 4, 3, 0, 1, 4, 3, 4 },
            { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
            { 3, 5, 4, 3, 2, 6, 4, 4, 3 },
            { 3, 5, 1, 3, 7, 5, 3, 6, 4 },
            { 6, 2, 4, 3, 4, 5, 4, 5, 1 }
        };
        List<List<List<Integer>>> ans = findPathInMaze(mat);
        for (List<List<Integer>> path : ans) {
            for (List<Integer> cell : path) {
                System.out.print("(" + cell.get(0) + ", " + cell.get(1) + ") ");
            }
            System.out.println();
        }
    }
}