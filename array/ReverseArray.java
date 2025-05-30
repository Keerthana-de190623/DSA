public class ReverseArray {
    public static void reverseArray(int[] arr,int n){
        int temp ;
        n=arr.length;
        for(int i=0;i<n/2;i++){
            
            temp =arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
        }
    }
    public static void main(String[] args) {
        int[] a={1,8,7,9,15,17,58};
        int n=a.length;
        reverseArray(a, n);
        for(int val:a){
                    System.out.print(" "+val);
        }

    }
}
