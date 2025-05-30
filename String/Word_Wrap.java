package String;

import java.util.Arrays;

public class Word_Wrap {

    private int[][] dp;

private int helper(int curr, int space, int[] arr, int k) {
    // Base case
    if (curr == arr.length) {
        return 0;
    }

    if (dp[curr][space] != -1) {
        return dp[curr][space];
    }

    // Option 1: Continue on the same line
    int a = Integer.MAX_VALUE;
    int newSpace = space + 1 + arr[curr];
    if (newSpace <= k) {
        a = helper(curr + 1, newSpace, arr, k);
    }

    //  Move to a new line
    int b = helper(curr + 1, arr[curr], arr, k)+(k-space)*(k-space);
    return dp[curr][space] = Math.min(a, b);
}

public int solveWordWrap(int[] arr, int k) {
    int n = arr.length;
    dp = new int[n + 1][k + 1];
    for (int[] row : dp) {
        Arrays.fill(row, -1);
    }
    return helper(1, arr[0], arr, k);
}

}
