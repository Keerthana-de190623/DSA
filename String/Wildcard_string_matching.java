package String;

public class Wildcard_string_matching {
    

    static boolean solve(String wild, String patt, int i, int j){
        if(i<0 && j>=0){
            return false;
        }
        if(i<0 && j<0){
            return true;
        }
        if(j<0 && i>=0){
            for(int k=0;k<=i;k++){
                if(wild.charAt(k)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(wild.charAt(i)==patt.charAt(j) || wild.charAt(i)=='?'){
            return solve(wild, patt, i-1, j-1);
        }
        if(wild.charAt(i)=='*'){
            return solve(wild, patt, i-1, j) || solve(wild, patt, i, j-1);
        }
        return false;
    }
    @SuppressWarnings("unused")
    static boolean match(String wild, String pattern)
    {
        // code here
        
        return solve(wild, pattern, wild.length()-1, pattern.length()-1);
    }
}
