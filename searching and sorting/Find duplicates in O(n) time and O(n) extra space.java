

import java.util.*;

class GfG {

    static List<Integer> findDuplicates(Integer[] arr) {

        // Step 1: Create an empty hashmap to store
        // element frequencies
        int n = arr.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Step 2: Iterate through the array and
        // count element frequencies
        for (int i = 0; i < n; i++) {
            freqMap.put(arr[i],
                        freqMap.getOrDefault(arr[i], 0)
                            + 1);
        }

        // Step 3: Iterate through the hashmap to find
        // duplicates
        for (Map.Entry<Integer, Integer> entry :
             freqMap.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        // Step 4: If no duplicates found, add -1 to the
        // result
        if (result.isEmpty()) {
            result.add(-1);
        }

        // Step 6: Return the result list containing
        // duplicate elements or -1
        return result;
    }

    public static void main(String[] args) {

        Integer[] arr = { 1, 6, 5, 2, 3, 3, 2 };
        List<Integer> duplicates = findDuplicates(arr);

        for (int element : duplicates) {
            System.out.print(element + " ");
        }
    }
}