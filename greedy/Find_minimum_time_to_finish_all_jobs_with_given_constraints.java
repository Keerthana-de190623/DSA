package greedy;
public class Find_minimum_time_to_finish_all_jobs_with_given_constraints {
    
// Java program to find the minimum time required  
// to finish all jobs using Binary Search  
// Java program to find the minimum time required  
// to finish all jobs using Binary Search  

    // Function to find the maximum job duration  
    static int getMax(int job[]) {
        int res = job[0];

        // Find the maximum time among all jobs  
        for (int i = 1; i < job.length; i++) {  
            if (job[i] > res) {  
                res = job[i];  
            }
        }
        return res;
    }

    // Function to check if jobs can be completed within  
    // 't' time using at most 'k' assignees  
    static boolean isPossible(int job[], int t, int k) {
        
        // Number of assignees required 
        int cnt = 1;   
        
        // Time assigned to the current assignee
        int curr = 0;    

        for (int i = 0; i < job.length;) {
            
            // If adding the current job exceeds 't',
            // assign a new assignee  
            if (curr + job[i] > t) {
                curr = 0;
                cnt++;
            } else {
                
                // Otherwise, add job time to the 
                // current assignee  
                curr += job[i];
                i++;
            }
        }
        
        return (cnt <= k);
    }

    // Function to find the minimum time required to
    // finish all jobs  
    static int findMinTime(int job[], int k, int t) {
        int start = 0, end = 0, ans;

        // Compute the total time and the maximum
        // job duration  
        for (int j : job) {
            
            // Total sum of job times
            end += j; 
            
            // Maximum job duration
            start = Math.max(start, j);    
        }
        
        // Initialize answer to the upper bound 
        ans = end;   

        // Perform binary search to find the minimum
        // feasible time  
        while (start <= end) {
            int mid = (start + end) / 2;

            // If jobs can be assigned within 'mid' time  
            if (isPossible(job, mid, k)) {
                ans = Math.min(ans, mid);  
                end = mid - 1;  
            } else {
                start = mid + 1;  
            }
        }

        // Return the minimum time required  
        return ans * t;
    }

    public static void main(String[] args) {
        int job[] = {10, 7, 8, 12, 6, 8};
        int k = 4, t = 5;
        
        System.out.println(findMinTime(job, k, t));
    }
}

