
import java.util.ArrayList;

class GfG {

    // Check if placement is safe
    static boolean isSafe(ArrayList<Integer> board, 
                          int currRow, int currCol) {
      
        for(int i = 0; i < board.size(); i++) {
            int placedRow = board.get(i);
            int placedCol = i + 1;

            // Check diagonals
            if(Math.abs(placedRow - currRow) == 
               Math.abs(placedCol - currCol)) {
                return false; // Not safe
            }
        }
        return true; // Safe to place
    }

    // Recursive utility to solve
    static void nQueenUtil(int col, int n, 
                           ArrayList<Integer> board, 
                           ArrayList<ArrayList<Integer>> res, 
                           boolean[] visited) {

        // If all queens placed, add to res
        if(col > n) {
            res.add(new ArrayList<>(board));
            return;
        }

        // Try each row in column
        for(int row = 1; row <= n; row++) {

            // If row not used
            if(!visited[row]) {

                // Check safety
                if(isSafe(board, row, col)) {

                    // Mark row
                    visited[row] = true;

                    // Place queen
                    board.add(row);

                    // Recur for next column
                    nQueenUtil(col + 1, n, board, 
                              res, visited);

                    // Backtrack
                    board.remove(board.size()-1);
                    visited[row] = false;
                }
            }
        }
    }

    // Function to solve N-Queen
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> board = new ArrayList<>();
        boolean[] visited = new boolean[n +1];
        nQueenUtil(1, n, board, res, visited);
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<Integer>> res = nQueen(n);
      
        for(ArrayList<Integer> row : res) {
            System.out.print("[");
            for(int i = 0; i < row.size(); i++) {
              
                System.out.print(row.get(i));
                if(i != row.size()-1)
                  	System.out.print(" ");
            }
            System.out.println("]");
        }
    }
}