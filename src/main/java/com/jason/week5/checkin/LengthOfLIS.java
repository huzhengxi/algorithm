package com.jason.week5.checkin;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * <p>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLIS {

  public int lengthOfLIS(int[] nums) {
    int len = nums.length;
    if (len < 2) {
      return len;
    }

    int[] dp = new int[len];
    int res = 0;
    Arrays.fill(dp, 1);

    for (int i = 1; i < len; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      res = Math.max(res, dp[i]);
    }

    return res;
  }

  public static void main(String[] args) {
    int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    LengthOfLIS lengthOfLIS = new LengthOfLIS();
    System.out.println(lengthOfLIS.lengthOfLIS(nums));

    int[] nums1 = {0, 1, 0, 3, 2, 3};
    System.out.println(lengthOfLIS.lengthOfLIS(nums1));

    int[] nums2 = {7, 7, 7, 7, 7, 7, 7};
    System.out.println(lengthOfLIS.lengthOfLIS(nums2));
  }
}
