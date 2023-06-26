/*
Q) Given an array nums with n objects colored red, 
white, or blue, sort them in-place so that objects of 
the same color are adjacent, with the colors in the 
order red, white, and blue.We will use the integers 
0, 1, and 2 to represent the color red, white, and 
blue, respectively.You must solve this problem without 
using the library's sort function.

A1) used counting sort technique

    TC - O(N) SC - O(1)
 */

public class sort_colors {
    public void A1(int[] nums) {
        int n = nums.length, oc = 0, tc = 0, idx = n - 1;
        for (int i = 0; i < n; i++)
            if (nums[i] == 1)
                oc++;
            else if(nums[i] == 2)
                tc++;
        while (tc-- > 0)
            nums[idx--] = 2;
        while (oc-- > 0)
            nums[idx--] = 1;
        while(idx >= 0)
            nums[idx--] = 0;
    }
}
