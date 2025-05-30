import java.util.*;

class allpossiblecombnations {
    public static List<List<Integer>> combine(int[] arr, int r) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr, r, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] arr, int r, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == r) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]);
            backtrack(arr, r, i + 1, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int r = 2;
        List<List<Integer>> combinations = combine(arr, r);
        for (List<Integer> comb : combinations) {
            System.out.println(comb);
        }
    }
}
