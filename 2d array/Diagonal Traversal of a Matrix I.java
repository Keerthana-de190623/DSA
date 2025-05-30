// Java program to find Diagonal Traversal of a Matrix
import java.util.*;

class GfG {

    // Function that returns elements of given mat in diagonal order
    static ArrayList<Integer> diagonalOrder(int[][] mat) {
        ArrayList<Integer> res = new ArrayList<>();

        int n = mat.length;
        int m = mat[0].length;

        // There will be n+m-1 diagonals in total
        for (int line = 1; line <= (n + m - 1); line++) {

            // Get column index of the first element in 
            // this diagonal. The index is 0 for first 'n' 
            // lines and (line - n) for remaining lines
            int startCol = Math.max(0, line - n);

            // Get count of elements in this diagonal
            // Count equals minimum of line number, (m-startCol) and n
            int count = Math.min(Math.min(line, m - startCol), n);

            // Process elements of this diagonal
            for (int j = 0; j < count; j++) {

                // Calculate row and column indices 
                // for each element in the diagonal
                int row = Math.min(n, line) - j - 1;
                int col = startCol + j;
                res.add(mat[row][col]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16 },
            { 17, 18, 19, 20 }
        };
        ArrayList<Integer> res = diagonalOrder(mat);
        for (int val : res) System.out.print(val + " ");
        System.out.println();
    }
}