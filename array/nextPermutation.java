class nextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // Step 1: Find first decreasing element
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Step 2: Find next greater element to swap with
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Step 3: Swap
            swap(nums, i, j);
        }

        // Step 4: Reverse the rest
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
