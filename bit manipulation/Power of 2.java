class Solution {
    public static boolean isPowerofTwo(int n) {
     int k=1;
        while(k<n) k=k*2;
            if(k==n)return true;
            else return false;
        }
    }