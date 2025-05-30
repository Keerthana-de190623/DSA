package greedy;
import java.util.PriorityQueue;
public class Minimum_sum_of_two_numbers_formed_from_digits_of_an_array {
    
// Importing necessary libraries

    public static int minSum(int[] arr) {
        
        // Using a priority queue to simulate a min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.add(num);
        }

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        while (!minHeap.isEmpty()) {
            num1.append(minHeap.poll());
            if (!minHeap.isEmpty()) {
                num2.append(minHeap.poll());
            }
        }

        return Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 0, 7, 4};
        System.out.println(minSum(arr));
    }
}