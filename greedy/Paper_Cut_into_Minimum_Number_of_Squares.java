package greedy;
import java.util.*;
public class Paper_Cut_into_Minimum_Number_of_Squares {
    
// Java Program to find minimum number of squares to cut
// from a paper of size axb



    // function to get the hash key for remSq array
    static int getKey(int[] remSq, int b) {
        int base = 1;
        int key = 0;
        for (int i = 0; i < b; i++) {
            key += (remSq[i] * base);
            base = base * (b + 1);
        }
        return key;
    }

    // Recursive function to find the minimum number of square cuts
    // for a given remSq array
    static int minCutUtil(int[] remSq, int a, int b,
                          Map<Integer, Integer> memo) {

        // pointers to mark the start and end of range 
        // with maximum remaining squares
        int start = 0, end;

        // Check if we have previously calculated the answer
        // for the same state
        int key = getKey(remSq, b);
        if (memo.containsKey(key))
            return memo.get(key);

        int maxRemSq = 0;

        // Find the starting point of min height
        for (int i = 0; i < b; i++) {
            if (remSq[i] > maxRemSq) {
                maxRemSq = remSq[i];
                start = i;
            }
        }

        // If max remaining squares = 0, then we have already
        // cut the entire paper
        if (maxRemSq == 0)
            return 0;

        end = start;
        int[] newRemSq = Arrays.copyOf(remSq, b);

        int ans = Integer.MAX_VALUE;

        // Find the ending point of min height
        while (end < b) {

            // length of edge of square from start till current end
            int squareEdge = end - start + 1;

            // If the current column does not have maximum remaining
            // squares or if it's impossible to cut a square of
            // size squareEdge, then break out of the loop
            if (newRemSq[end] != maxRemSq ||
                newRemSq[end] - squareEdge < 0)
                break;

            // If we can cut a square of size squareEdge, 
            // update the remainingSquares
            for (int i = start; i <= end; i++)
                newRemSq[i] = maxRemSq - squareEdge;

            // Find the solution for new remainingSquares
            ans = Math.min(ans, 1 + minCutUtil(newRemSq, a, b, memo));
            end += 1;
        }

        memo.put(key, ans);
        return ans;
    }

    // Function to find the minimum number of squares we can cut 
    // using paper of size a X b
    static int minCut(int a, int b) {

        // if the given rectangle is a square
        if (a == b)
            return 1;

        // Initialize remaining squares = a for all the b columns
        int[] remSq = new int[b];
        Arrays.fill(remSq, a);

        Map<Integer, Integer> memo = new HashMap<>();
        return minCutUtil(remSq, a, b, memo);
    }

    public static void main(String[] args) {

        // Sample Input
        int a = 13, b = 11;

        // Function call to get minimum number 
        // of squares for axb
        System.out.println(minCut(a, b));
    }
}
