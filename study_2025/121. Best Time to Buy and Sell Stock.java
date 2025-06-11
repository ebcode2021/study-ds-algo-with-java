class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = 10000;
        int maxPrice = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxPrice) {
                maxPrice = price - minPrice;
            }
        }
        return maxPrice;
    }
}