class kthSmallest {
    public static int kth_Smallest(int[] arr, int k) {
        // Your code here
        for(int i=0; i<arr.length;i++){
        for(int j=i+1; j<arr.length;j++){
            if(arr[i]>arr[j]){
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
    }
    return arr[k-1];
    }
}
