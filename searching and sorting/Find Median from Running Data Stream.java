// Java program to find Median from Running Data Stream
// Using Insertion Sort
import java.util.ArrayList;

class GfG {
    
    // Function to print median of stream of integers
    static ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> res = new ArrayList<>();
        res.add((double) arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int num = arr[i];

            // shift elements to right to create space to insert
            // the current element at its correct position
            while (j >= 0 && arr[j] > num) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = num;

            int len = i + 1;
            double median;

            // If odd number of integers are read from stream
            // then middle element in sorted order is median
            // else average of middle elements is median
            if (len % 2 != 0) {
                median = arr[len / 2];
            } else {
                median = (arr[(len / 2) - 1] + arr[len / 2]) / 2.0;
            }

            res.add(median);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 15, 1, 3, 2, 8};
        ArrayList<Double> res = getMedian(arr);
        
        for (int i = 0; i < res.size(); i++) {
            System.out.printf("%.2f ", res.get(i));
        }
    }
}