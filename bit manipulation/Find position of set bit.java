class Solution {
    @SuppressWarnings("unused")
    static int findPosition(int N) {
       int index =1;
       if((N&(N-1))!=0){
           return -1;
       }
        while(N>0){
            int check = N&1;
            if(check==1){
                return index;
            }
            index++;
            N=N>>1;
        }
        return -1;
    }
}