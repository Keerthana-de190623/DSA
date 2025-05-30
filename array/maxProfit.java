class maxProfit {
    public int max_Profit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Found a cheaper day to buy
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice); // Try selling today
            }
        }

        return maxProfit;
    }
}
