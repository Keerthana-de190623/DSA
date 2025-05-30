public class MinMergePalindrome {
    public static int minMergeOperations(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left < right) {
            if (arr[left] == arr[right]) {
                left++;
                right--;
            } else if (arr[left] < arr[right]) {
                arr[left + 1] += arr[left];  // merge left with left+1
                left++;
                count++;
            } else {
                arr[right - 1] += arr[right];  // merge right with right-1
                right--;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 1};
        System.out.println(minMergeOperations(arr)); // Output: 1
    }
}
