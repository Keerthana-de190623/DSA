import java.util.HashMap;

public class SmallestWindowSubstring {

    @SuppressWarnings("UnnecessaryUnboxing")
    public static String minWindow(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) return "";

        // Frequency map for characters in s2
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : s2.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();
        int have = 0, needCount = need.size();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s1.length(); right++) {
            char c = s1.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                have++;
            }

            while (have == needCount) {
                // Update result
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Shrink the window
                char leftChar = s1.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (need.containsKey(leftChar) && window.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    have--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s1.substring(start, start + minLen);
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(minWindow("timetopractice", "toc"));    // Output: "toprac"
        System.out.println(minWindow("zoomlazapzo", "oza"));       // Output: "apzo"
        System.out.println(minWindow("zoom", "zooe"));             // Output: ""
    }
}
