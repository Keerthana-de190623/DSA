
class GfG {

    // Function which finds the minimum 
    // cost to make array elements equal
    static int minCost(int[] arr) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;

        // Try each element as the target value
        for (int i = 0; i < n; i++) {
            int currentCost = 0;

            // Calculate cost of making all 
            // elements equal to arr[i]
            for (int j = 0; j < n; j++) {
                currentCost += Math.abs(arr[j] - arr[i]);
            }

            // Update minimum cost if current cost is lower
            ans = Math.min(ans, currentCost);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 100, 101};
        System.out.println(minCost(arr));
    }
}