// Java Program to find all Distinct Quadruplets with given
// Sum in an Array using Nested Loops

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class GfG {
    static List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;

        // Generating all possible quadruplets
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (arr[i] + arr[j] + arr[k] + arr[l] == target) {
                            List<Integer> curr = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                             
                             // Sort as needed in the output
                             Collections.sort(curr);
                          
                            // Making sure that all quadruplets with target
                            // sum are distinct
                            if (!res.contains(curr)) {
                                res.add(curr);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 4, 5, 7, 8};
        int target = 23;
        List<List<Integer>> ans = fourSum(arr, target);
        for (List<Integer> v : ans) {
            for (int x : v) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}