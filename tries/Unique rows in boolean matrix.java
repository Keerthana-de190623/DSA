
class GfG
{
    
    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c)
    {
        //add code here.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Set<Long> st = new HashSet<>();
        
        for(int i=0; i<r; i++){
            int p=0;
            long sum=0;
            ArrayList<Integer> temp = new ArrayList<>();
            
            for(int j=0; j<c; j++){
                sum+= a[i][j]* Math.pow(2, p);
                p++;
                temp.add(a[i][j]);
            }
            
            if(!st.contains(sum)){
                ans.add(temp);
                st.add(sum);
            }
        }
        
        return ans;
    }
}

