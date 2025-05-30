// Java program to print all subarrays
// in the array which has sum 0
import java.io.*;
import java.util.*;

// User defined pair class
class Pair {
    int first, second;
    Pair(int a, int b)
    {
        first = a;
        second = b;
    }
}

public class Print_all_subarrays_with_0_sum {
    static ArrayList<Pair> findSubArrays(int[] arr, int n)
    {
        // Array to store all the start and end
        // indices of subarrays with 0 sum
        ArrayList<Pair> out = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int prefix = 0;
            for (int j = i; j < n; j++) {
                prefix += arr[j];
                if (prefix == 0)
                    out.add(new Pair(i, j));
            }
        }
        return out;
    }

    // Function to print all subarrays with 0 sum
    static void print(ArrayList<Pair> out)
    {
        for (int i = 0; i < out.size(); i++) {
            Pair p = out.get(i);
            System.out.println("Subarray found from Index "
                               + p.first + " to "
                               + p.second);
        }
    }

    // Driver code
    public static void main(String args[])
    {

        // Given array
        int[] arr
            = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
        int n = arr.length;

        // Function Call
        ArrayList<Pair> out = findSubArrays(arr, n);

        // if we didn’t find any subarray with 0 sum,
        // then subarray doesn’t exists
        if (out.size() == 0)
            System.out.println("No subarray exists");
        else
            print(out);
    }
}