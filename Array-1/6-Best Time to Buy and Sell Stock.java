/**
 * If today's price is lower than the current buy price, update buy.
 * Otherwise, calculate the profit for today.
 * Time complexity: O(n), Space complexity: O(1)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, res = 0, buy = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] < buy)
                buy = prices[i];
            else {
                res = Math.max(res, prices[i] - buy);
            }
        }
        return res;
    }
}