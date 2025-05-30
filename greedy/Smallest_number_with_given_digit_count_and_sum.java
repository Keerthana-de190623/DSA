package greedy;
public class Smallest_number_with_given_digit_count_and_sum {
// Java program to find the smallest d-digit
// number with the given sum using 
// a brute force approach
    
    static String smallestNumber(int s, int d) {
        
        // The smallest d-digit number is 10^(d-1)
        int start = (int) Math.pow(10, d - 1);
        
        // The largest d-digit number is 10^d - 1
        int end = (int) Math.pow(10, d) - 1;

        // Iterate through all d-digit numbers
        for (int num = start; num <= end; num++) {
            
            int sum = 0, x = num;

            // Calculate sum of digits
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }

            // If sum matches, return the number
            // as a string
            if (sum == s) {
                return Integer.toString(num);
            }
        }

        // If no valid number is found, return "-1"
        return "-1";
    }

    // Driver Code
    public static void main(String[] args) {
        
        int s = 9, d = 2;
        
        System.out.println(smallestNumber(s, d));
    }
}