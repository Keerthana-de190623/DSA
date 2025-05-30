class GfG {
  
    // Calculate the maximum stolen value recursively
    static int maxLootRec(int[] arr, int n) {
    
        // If no houses are left, return 0.
        if (n <= 0) return 0;
      
        // If only 1 house is left, rob it. 
        if (n == 1) return arr[0];

        // Two Choices: Rob the nth house and do not rob the nth house 
        int pick = arr[n - 1] + maxLootRec(arr, n - 2);
        int notPick = maxLootRec(arr, n - 1);

        // Return the max of two choices
        return Math.max(pick, notPick);
    }

    // Function to calculate the maximum stolen value
    static int findMaxSum(int[] arr) {
        int n = arr.length;
      
        // Call the recursive function for n houses
        return maxLootRec(arr, n);
    }

    public static void main(String[] args) {
        int[] arr= {6, 5, 5, 7, 4};
        System.out.println(findMaxSum(arr));
    }
}