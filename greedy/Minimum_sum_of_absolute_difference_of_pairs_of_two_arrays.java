package greedy;
import java.util.Arrays;

public class Minimum_sum_of_absolute_difference_of_pairs_of_two_arrays {

    public static void main(String[] args) {
        long a[] = {4, 1, 8, 7};
        long b[] = {2, 3, 6, 5};
        int n = a.length;
        System.out.println(findMinSum(a, b, n));  // Output: 6
    }

    static long findMinSum(long a[], long b[], long n) {
        Arrays.sort(a);  // Sort array a
        Arrays.sort(b);  // Sort array b
        long sum = 0;
        for (int i = 0; i < n; i++)
            sum += Math.abs(a[i] - b[i]);
        return sum;
    }    
}

// // Java program to acquire
// // all n coins
// import java.util.Arrays;

// class GFG 
// {
    
//     // function to calculate min cost
//     static int minCost(int coin[], 
//                        int n, int k)
//     {
        
//         // sort the coins value
//         Arrays.sort(coin);

//         // calculate no. of 
//         // coins needed
//         int coins_needed = (int)Math.ceil(1.0 *
//                                   n / (k + 1));

//         // calculate sum of 
//         // all selected coins
//         int ans = 0;
        
//         for (int i = 0; i <= coins_needed - 1; 
//                                           i++)
//             ans += coin[i];

//         return ans;
//     }
    
//     // Driver code
//     public static void main(String arg[])
//     {
//         int coin[] = { 8, 5, 3, 10, 
//                        2, 1, 15, 25 };
//         int n = coin.length;
//         int k = 3;
        
//         System.out.print(minCost(coin, n, k));
//     }
// }

// // This code is contributed
// // by Anant Agarwal.