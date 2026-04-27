/**
 * When the running sum becomes negative, record the current element as a potential
 * maximum (handles case where all elements are negative), then reset sum to 0
 * to continue searching for positive subarrays.
 * Time complexity: O(n), Space complexity: O(1)
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, i = 0, sum = 0, res = Integer.MIN_VALUE;
        while (i < n) {
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
                res = Math.max(res, nums[i]);
            } else
                res = Math.max(res, sum);
            i++;
        }
        return res;
    }
}