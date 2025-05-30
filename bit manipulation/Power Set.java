import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution
{
    List<String> result = new ArrayList<>();
    
    public void solve(String curr,String s,int idx)
    {
        // base
        if(idx==s.length())
        {
            result.add(curr);
            return;
        }
        
        curr+=s.charAt(idx);
        solve(curr,s,idx+1);
        curr = curr.substring(0,curr.length()-1);
        solve(curr,s,idx+1);
        
    }
    
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        String curr="";
        solve(curr,s,0);
        
        Collections.sort(result);
        return result;
    }
}