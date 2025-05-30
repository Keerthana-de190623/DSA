// Java Implementation to Find the maximum 
// number possible after at most `k` swaps 
// using Recursion
import java.util.*;

class GfG {

    static String findMax(String s, int k) {
        
        // Base case: If no swaps are allowed
        if (k == 0) {
            return s;
        }

        int n = s.length();
        String ans = s;

        // Iterate through all character pairs
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                // Swap only if s[j] > s[i]
                if (s.charAt(i) < s.charAt(j)) {

                    // Perform the swap
                    s = swap(s, i, j);

                    // Recur to check maximum with
                    // one less swap allowed
                    String recResult = findMax(s, k - 1);
                    if (recResult.compareTo(ans) > 0) {
                        ans = recResult;
                    }

                    // Backtrack to original state
                    s = swap(s, i, j);
                }
            }
        }

        return ans;
    }

    static String findMaximumNum(String s, int k) {

        // Wrapper function to find result
        return findMax(s, k);
    }

    static String swap(String s, int i, int j) {

        // Swap characters at indices i and j
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }

    public static void main(String[] args) {
      
        String s = "7599";
        int k = 2;

        System.out.println(findMaximumNum(s, k));
    }
}