package String;

public class Count_Palindromic_Subsequences {
    
    @SuppressWarnings("unused")
    int countPS(String s) {
        // Your code here
        int n=s.length();
        
        // dp[i][j] contains total palindrome in Substring[i....j]
        int dp[][]= new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
            
        }
        
        //iterating over substring  of len 
        for(int len=2;len <=n;len++){
            //starting index of the substring 
            for(int i=0; i<=n-len ;i++){
                //ending index  doing -1 so that it stays inbound 
                 int j=len+i-1;
                 
                 if(s.charAt(i)==s.charAt(j)){
                     //means we can put i and j around palindrome encountered previously
                     //since every dp[i][j] contains total plaindrome in substring [i ... j]
                     dp[i][j]= (1+ dp[i+1][j] + dp[i][j-1]) ;
                 }else {
                     //not equal so taking both  and subtracting duplicates
                     dp[i][j] = ((dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1]));
                 }
            }
        }

  //total palindrome subsequences in substring [0....n)
        return dp[0][n-1];
        
    }
}
