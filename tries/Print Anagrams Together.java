class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        HashMap<String,ArrayList<String>> hm=new HashMap<>();
        
        for(String s:arr){
            
        char [] c=s.toCharArray();
        Arrays.sort(c);
        String ans=new String(c);
         if(!hm.containsKey(ans)){
             hm.put(ans,new ArrayList<>());
         }
                      hm.get(ans).add(s);
        
        }
        return new ArrayList<>(hm.values());
    }
}

 