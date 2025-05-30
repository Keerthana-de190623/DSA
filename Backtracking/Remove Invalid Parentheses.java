import java.util.*;

class GfG {

    // method returns true if string 
    // contains valid parenthesis
    static boolean isValidString(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                cnt++;
            else if (str.charAt(i) == ')')
                cnt--;
            if (cnt < 0)
                return false;
        }
        return (cnt == 0);
    }

    //  function to remove invalid parenthesis
    static List<String> validParenthesis(String str) {

        // to ignore already visited string
        HashMap<String, Integer> visit = new HashMap<>();

        //  queue to maintain BFS
        Queue<String> q = new LinkedList<>();

        // to store the valid strings
        List<String> res = new ArrayList<>();
        boolean level = false;

        //  pushing given string as starting node into queue
        q.add(str);
        
        // mark the string as visited
        visit.put(str, 1);

        // while queue is not empty
        while (!q.isEmpty()) {
            String temp = q.poll();

            // check if the string is valid
            if (isValidString(temp)) {
                
                // if valid, store it
                res.add(temp);

                // make level true, so that valid string 
                // of only that level are processed.
                level = true;
            }
            if (level)
                continue;

            for (int i = 0; i < temp.length(); i++) {

                // if current character is not a parenthesis
                // continue to next character
                if (temp.charAt(i) != '(' && temp.charAt(i) != ')')
                    continue;

                // Removing parenthesis from str and
                // pushing into queue,if not visited already
                String cur = temp.substring(0, i) + temp.substring(i + 1);
                if (!visit.containsKey(cur)) {
                    q.add(cur);
                    visit.put(cur, 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "(v)())()";
        List<String> res = validParenthesis(str);
        for (String s : res) {
            System.out.println(s);
        }
    }
}