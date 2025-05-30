
class GfG {

    static boolean isSafe(int x, int y, int n, int[][] board) {
        return (x >= 0 && y >= 0 && x < n &&
                y < n && board[x][y] == -1);
    }

    static boolean knightTourUtil(int x, int y, int step, int n,
                                   int[][] board,
                                   int[] dx, int[] dy) {

        // If all squares are visited
        if (step == n * n) {
            return true;
        }

        // Try all 8 possible knight moves
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isSafe(nx, ny, n, board)) {
                board[nx][ny] = step;

                if (knightTourUtil(nx, ny, step + 1,
                        n, board, dx, dy)) {

                    return true;
                }

                // Backtrack
                board[nx][ny] = -1;
            }
        }

        return false;
    }

    static int[][] knightTour(int n) {

        int[][] board = new int[n][n];
        for (int[] row : board) {
            java.util.Arrays.fill(row, -1);
        }

        // 8 directions of knight moves
        int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        // Start from top-left corner
        board[0][0] = 0;

        if (knightTourUtil(0, 0, 1, n, board, dx, dy)) {
            return board;
        }

        return new int[][] { {-1} };
    }


    public static void main(String[] args) {
        int n = 5;

        int[][] res = knightTour(n);

        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}