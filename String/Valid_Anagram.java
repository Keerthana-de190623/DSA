package String;

public class Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // assuming lowercase letters

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }
}


// package String;

// import java.util.Arrays;

// class validannagram {
//     public boolean is_Anagram(String s, String t) {
//         char[] sChars = s.toCharArray();
//         char[] tChars = t.toCharArray();
        
//         Arrays.sort(sChars);
//         Arrays.sort(tChars);
        
//         return Arrays.equals(sChars, tChars);
//     }
// }