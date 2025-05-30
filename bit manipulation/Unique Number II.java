import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] singleNum(int[] arr) {
        // Code here
        Map<Integer, Integer> hash = new HashMap<>();
        for(int num: arr)
        {
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) 
        {
            if (entry.getValue() == 1) 
            {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return new int[]{result.get(0), result.get(1)};
    }
}