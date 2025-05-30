package greedy;
import java.util.*;
import java.util.AbstractMap;
import java.util.HashMap;

public class Rearrange_characters_in_a_String_such_that_no_two_adjacent_characters_are_same {
    
// Java program to rearrange characters in a string
// so that no two adjacent characters are same.




    
    // Function to rearrange character of a string
    // so that no two adjacent characters are same
    static String rearrangeString(String s) {
        int n = s.length();
        
        // Store frequencies of all characters in string
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        
        // Insert all characters with their frequencies
        // into a priority_queue
        PriorityQueue<Map.Entry<Character, Integer>> pq = 
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(freq.entrySet());
        
        StringBuilder res = new StringBuilder();
        
        // Work as the previous visited element
        // Initial previous element be '#' and its frequency '-1'
        Map.Entry<Character, Integer> prev = new AbstractMap.SimpleEntry<>('#', -1);
        
        while (!pq.isEmpty()) {
            // Pop top element from queue and add it
            // to string.
            Map.Entry<Character, Integer> p = pq.poll();
            res.append(p.getKey());
            
            // If frequency of previous character is less
            // than zero that means it is useless, we
            // need not to push it
            if (prev.getValue() > 0)
                pq.offer(prev);
            
            // Make current character as the previous 'char'
            // decrease frequency by 'one'
            prev = new AbstractMap.SimpleEntry<>(p.getKey(), p.getValue() - 1);
        }
        
        // If length of the resultant string and original
        // string is not same then string is not valid
        if (res.length() != n)
            return "";
        
        // Valid String
        return res.toString();
    }
    
    public static void main(String[] args) {
        String s = "aaabc";
        System.out.println(rearrangeString(s));
    }
}
