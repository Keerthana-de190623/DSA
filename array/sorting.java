public class sorting{
    public static void Selectio_sort(int a[],int n){
        for(int i=0;i<n-1;i++){
            int big=i;
            for(int j=i+1;j<n;j++){
                if(a[j]<a[big])
                {
                    big=j;
                }
            }
            int temp = a[big];
            a[big] = a[i];
            a[i] = temp;

        }
        System.out.println("After Sorting:");
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        int a[] ={47,68,2,8,4,9,4,3,41,97,55,281,864};
        int n=a.length;
        System.out.println("before sorting:");
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        Selectio_sort(a, n);
    }
}





























// import java.util.*;

// public class tUf {
//     static void selection_sort(int arr[], int n) {
//         for (int i = 0; i < n - 1; i++) {
//             int mini = i;
//             for (int j = i + 1; j < n; j++) {
//                 if (arr[j] < arr[mini]) {
//                     mini = j;
//                 }
//             }
//             //swap
//             int temp = arr[mini];
//             arr[mini] = arr[i];
//             arr[i] = temp;
//         }

//         System.out.println("After selection sort:");
//         for (int i = 0; i < n; i++) {
//             System.out.print(arr[i] + " ");
//         }
//         System.out.println();
//     }

//     public static void main(String args[]) {

//         int arr[] = {13, 46, 24, 52, 20, 9};
//         int n = arr.length;
//         System.out.println("Before selection sort:");
//         for (int i = 0; i < n; i++) {
//             System.out.print(arr[i] + " ");
//         }
//         System.out.println();
//         selection_sort(arr, n);
//     }
// }