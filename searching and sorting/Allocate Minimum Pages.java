class Solution {
    public static int findPages(int[] arr, int k) {
        int n=arr.length;
        if(k>n)return -1;
        int low=Integer.MIN_VALUE;
        int high=0;
        int ans=-1;
        for(int i:arr){
            high+=i;
            low=Math.max(i,low);
        }
        while(low<=high){
            int mid=(low+high)/2;
            if(possible(arr,mid,k)){
                high=mid-1;
                ans=mid;
            }
            else low=mid+1;
        }
        return ans;
    }
    static boolean possible(int[] arr,int pages,int k){
        int students=1;
        int pagesStudent=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]+pagesStudent<=pages){
                pagesStudent+=arr[i];
            }
            else{
                students++;
                pagesStudent=arr[i];
                if(students>k)return false;
            }
        }
        return true;
    }
}