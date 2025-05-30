public class FindMinInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        // If the array is not rotated (sorted), the first element is the smallest
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than rightmost, min is to the right
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Else min is at mid or to the left
                right = mid;
            }
        }
        // After the loop, left == right pointing to the minimum element
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum element is: " + findMin(nums)); // Output: 0
    }
}
