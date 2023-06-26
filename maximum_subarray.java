/**
 Q) Given an integer array nums, find the subarray with 
    the largest sum, and return its sum.
A1) Kadane's Algo
 */

public class maximum_subarray {
    public int A1(int[] nums) {
        int n = nums.length, res = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            res = Math.max(res, sum);
            if (sum < 0)
                sum = 0;
        }
        return res;
    }
}
