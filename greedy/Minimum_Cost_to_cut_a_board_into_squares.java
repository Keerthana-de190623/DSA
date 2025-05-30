package greedy;
import java.util.Arrays;
public class Minimum_Cost_to_cut_a_board_into_squares {
    
// Java program to find the minimum cost to cut a board
// into squares using the Greedy Technique.

    static int minimumCostOfBreaking(int m, int n, 
                                     int[] x, int[] y) {
        
        // Sort the cutting costs in ascending order
        Arrays.sort(x);
        Arrays.sort(y); 

        // Pieces in each direction
        int hCount = 1, vCount = 1; 
        int i = x.length - 1, j = y.length - 1; 
        int totalCost = 0;

        // Process the cuts in greedy manner
        while (i >= 0 && j >= 0) {
            
            // Choose the larger cost cut to 
            // minimize future costs
            if (x[i] >= y[j]) {
                totalCost += x[i] * hCount; 
                vCount++;
                i--;
            } 
            else {
                totalCost += y[j] * vCount; 
                hCount++;
                j--;
            }
        }

        // Process remaining vertical cuts
        while (i >= 0) {
            totalCost += x[i] * hCount;
            vCount++;
            i--;
        }

        // Process remaining horizontal cuts
        while (j >= 0) {
            totalCost += y[j] * vCount;
            hCount++;
            j--;
        }

        return totalCost;
    }

    // Driver Code
    public static void main(String[] args) {
        
        int m = 6, n = 4;
        int[] x = {2, 1, 3, 1, 4};
        int[] y = {4, 1, 2};

        System.out.println(minimumCostOfBreaking(m, n, x, y));
    }
}