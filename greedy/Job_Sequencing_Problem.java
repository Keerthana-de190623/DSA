package greedy;
import java.util.ArrayList;

public class Job_Sequencing_Problem {
    
// Java program to solve job sequencing
// problem with maximum profit

     static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;

        // total job count which is done
        int cnt = 0;

        // total profit earned
        int totProfit = 0;

        // pair the profit and deadline of all the jobs together
        ArrayList<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{profit[i], deadline[i]});
        }

        // sort the jobs based on profit in decreasing order
        jobs.sort((a, b) -> Integer.compare(b[0], a[0]));

        // array to check time slot for job
        int[] slot = new int[n];

        for (int i = 0; i < n; i++) {
            int start = Math.min(n, jobs.get(i)[1]) - 1;
            for (int j = start; j >= 0; j--) {

                // if slot is empty
                if (slot[j] == 0) {
                    slot[j] = 1;
                    cnt++;
                    totProfit += jobs.get(i)[0];
                    break;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(cnt);
        result.add(totProfit);
        return result;
    }

    public static void main(String[] args) {
        int[] deadline = {2, 1, 2, 1, 1};
        int[] profit = {100, 19, 27, 25, 15};

        ArrayList<Integer> ans = jobSequencing(deadline, profit);
        System.out.println(ans.get(0) + " " + ans.get(1));
    }
}