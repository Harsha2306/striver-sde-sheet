/**
 * Sorts an array containing only 0s, 1s, and 2s using the Dutch National Flag algorithm.
 * Uses three pointers (low, mid, high) to partition the array in a single pass:
 * - Elements before low are 0s
 * - Elements between low and mid-1 are 1s
 * - Elements between mid and high are unprocessed
 * - Elements after high are 2s
 * Time complexity: O(n), Space complexity: O(1)
 */

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length, low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (nums[mid] == 2) {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
        }
    }
}