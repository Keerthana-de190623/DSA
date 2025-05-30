package greedy;
import java.util.*;

class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class MaximumLengthChainOfPairs {

    static int maxChainLength(Pair arr[], int n) {
        int[] mcl = new int[n];

        // Initialize all MCL values as 1
        Arrays.fill(mcl, 1);

        // Compute optimized chain length using DP
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i].a > arr[j].b && mcl[i] < mcl[j] + 1) {
                    mcl[i] = mcl[j] + 1;
                }
            }
        }

        // Find maximum value in mcl[]
        int max = 0;
        for (int val : mcl) {
            max = Math.max(max, val);
        }

        return max;
    }

    public static void main(String[] args) {
        Pair[] arr = new Pair[] {
            new Pair(5, 24),
            new Pair(15, 25),
            new Pair(27, 40),
            new Pair(50, 60)
        };

        System.out.println(
            "Length of maximum size chain is " +
            maxChainLength(arr, arr.length)
        );
    }
}
