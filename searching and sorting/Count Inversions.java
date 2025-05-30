class Solution {
    public static int mergeSort(int[] arr, int si, int ei){
        int cnt=0;
        //Base Case 
        if(si>=ei) return cnt;
        
        int mid = si+(ei-si)/2;
        
        cnt+=mergeSort(arr, si, mid);
        cnt+=mergeSort(arr, mid+1, ei);
        
        cnt+=merge(arr, si, mid, ei);
        
        return cnt;
    }
    
    public static int merge(int[] arr, int si, int mid, int ei){
        int[] temp = new int[ei-si+1];
        //ptr
        int i=si, j=mid+1, k=0;
        
        int cnt=0;
        //Fill temp arr
        while(i<=mid && j<=ei){
            if(arr[i]>arr[j]){
                temp[k++]=arr[j++];
                cnt+=(mid-i+1);
            }
            else temp[k++]=arr[i++];
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }

        while(j<=ei){
            temp[k++]=arr[j++];
        }

        i=si;
        // Fill back nums arr
        for(int v: temp) arr[i++]=v;
        
        return cnt;
    }
    
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length-1);
    }
}

 

//TC=O(nlogn)

//SC=O(n)

 