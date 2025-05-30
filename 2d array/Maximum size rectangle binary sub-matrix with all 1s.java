
import java.util.Stack;

class GfG {
    
    // Function to find the maximum area of 
    // rectangle in a histogram.
    static int getMaxArea(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int res = 0;
        int tp, curr;

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {

                // The popped item is to be considered as the 
                // smallest element of the histogram
                tp = s.pop();

                // For the popped item previous smaller element is 
                // just below it in the stack (or current stack top)
                // and next smaller element is i
                int width = s.isEmpty() ? i : i - s.peek() - 1;

                res = Math.max(res, arr[tp] * width);
            }
            s.push(i);
        }

        // For the remaining items in the stack, next smaller does
        // not exist. Previous smaller is the item just below in
        // stack.
        while (!s.isEmpty()) {
            tp = s.pop();
            curr = arr[tp] * (s.isEmpty() ? n : n - s.peek() - 1);
            res = Math.max(res, curr);
        }

        return res;
    }
    
    // Function to find the maximum area of rectangle
    // in a 2D matrix.
    static int maxArea(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        // Array to store matrix 
        // as a histogram.
        int[] arr = new int[m];

        int ans = 0;

        // Traverse row by row.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    arr[j]++;
                } else {
                    arr[j] = 0;
                }
            }

            ans = Math.max(ans, getMaxArea(arr));
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {0, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0}
        };

        System.out.println(maxArea(mat));
    }
}