package String;
import java.util.*;
class Solution {
    public String removeConsecutiveCharacter(String s) {
        // code here
        StringBuilder ans=new StringBuilder();
        
        for(int i=0 ;i<s.length();i++){
            
            if(i==0 || s.charAt(i)!=s.charAt(i-1)){
                ans.append(s.charAt(i));
            }
        }return ans.toString();
    }
}