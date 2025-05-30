import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Find_common_elements_in_three_sorted_arrays {
    




    // Function to find common elements in three arrays
    public static ArrayList<Integer>
    commonElements(ArrayList<Integer> arr1,
                   ArrayList<Integer> arr2,
                   ArrayList<Integer> arr3)
    {
        // TreeMap to mark the common elements
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Mark all the elements in the first array with
        // value=1
        for (int ele : arr1) {
            map.put(ele, 1);
        }

        // Mark all the elements which are common in first
        // and second array with value = 2
        for (int ele : arr2) {
            if (map.containsKey(ele) && map.get(ele) == 1)
                map.put(ele, 2);
        }

        // Mark all the elements which are common in first,
        // second, and third array with value = 3
        for (int ele : arr3) {
            if (map.containsKey(ele) && map.get(ele) == 2)
                map.put(ele, 3);
        }

        // Store all the common elements
        ArrayList<Integer> commonElements
            = new ArrayList<>();
        for (int ele : map.keySet()) {
            if (map.get(ele) == 3)
                commonElements.add(ele);
        }

        // Return the common elements which are common in
        // all the three arrays
        return commonElements;
    }

    public static void main(String[] args)
    {
        // Sample Input
        ArrayList<Integer> arr1
            = new ArrayList<>(List.of(1, 5, 10, 20, 30));
        ArrayList<Integer> arr2
            = new ArrayList<>(List.of(5, 13, 15, 20));
        ArrayList<Integer> arr3
            = new ArrayList<>(List.of(5, 20));

        // Function call and storing result
        ArrayList<Integer> common
            = commonElements(arr1, arr2, arr3);

        if (common.size() == 0)
            System.out.print(-1);

        for (int i = 0; i < common.size(); i++)
            System.out.print(common.get(i) + " ");
    }
}