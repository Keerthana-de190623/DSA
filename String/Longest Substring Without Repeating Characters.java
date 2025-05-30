class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0; 
        int end = 0;   
        int result = 0; 
        int n = s.length();
        while (end < n) {
            String sub = s.substring(start, end + 1); 
            if (isUnique(sub)) { 
                result = Math.max(result, sub.length()); 
                end++; 
            } else {
                start++;
            }
        }
        return result; 
    }
    private static boolean isUnique(String s) {
        if (s.length() > 128) { 
            return false;
        }
        boolean[] marker = new boolean[128];
        for (char c : s.toCharArray()) {
            if (marker[c]) { 
                return false;
            }
            marker[c] = true;         }
        return true; 
    }
}
