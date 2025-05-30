
import java.util.ArrayList;
import java.util.Arrays;

class GfG {

    // Function to generate all combinations
    // of arr that sums to target.
    static void makeCombination(int[] arr, int remSum, ArrayList<Integer> cur, 
                                       ArrayList<ArrayList<Integer>> res, int index) {
        
        // If remSum is 0 then add the combination to the result
        if (remSum == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        // Invalid Case: If remSum is less than 0 or if index >= arr.length
        if (remSum < 0 || index >= arr.length)
            return;
        
        // Add the current element to the combination
        cur.add(arr[index]);

        // Recur with the same index
        makeCombination(arr, remSum - arr[index], cur, res, index);

        // Remove the current element from the combination
        cur.remove(cur.size() - 1);

        // Recur with the next index
        makeCombination(arr, remSum, cur, res, index + 1);
    }

    // Function to find all combinations of elements
    // in array arr that sum to target.
    static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {
      	Arrays.sort(arr);

        // List to store combinations
        ArrayList<Integer> cur = new ArrayList<>();

        // List to store valid combinations
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        makeCombination(arr, target, cur, res, 0);

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8};
        int target = 8;

        ArrayList<ArrayList<Integer>> res = combinationSum(arr, target);

        for (ArrayList<Integer> v : res) {
            for (int i : v) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}