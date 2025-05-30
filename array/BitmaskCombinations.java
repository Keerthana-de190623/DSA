import java.util.*;

public class BitmaskCombinations {

    public static List<List<Integer>> combine(int[] arr, int r) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();

        int total = 1 << n; // 2^n combinations
        for (int mask = 0; mask < total; mask++) {
            if (Integer.bitCount(mask) == r) {
                List<Integer> combination = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        combination.add(arr[i]);
                    }
                }
                result.add(combination);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int r = 2;
        List<List<Integer>> combinations = combine(arr, r);
        for (List<Integer> c : combinations) {
            System.out.println(c);
        }
    }
}
