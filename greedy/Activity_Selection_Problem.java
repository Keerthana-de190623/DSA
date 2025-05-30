package greedy;

import java.util.Arrays;
public class Activity_Selection_Problem {

    // Function to solve the activity selection problem
    static int activitySelection(int[] start, int[] finish)
    {
        int n = start.length;
        int ans = 0;

        // Store activities as (finish, start) pairs
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = finish[i];
            arr[i][1] = start[i];
        }

        // Sort activities based on finish time
        Arrays.sort(arr,
                    (a, b) -> Integer.compare(a[0], b[0]));

        // To store the end time of last activity
        int finishtime = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i][1] > finishtime) {
                finishtime = arr[i][0];
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] finish = { 2, 4, 6, 7, 9, 9 };

        System.out.println(
            activitySelection(start, finish));
    }
}