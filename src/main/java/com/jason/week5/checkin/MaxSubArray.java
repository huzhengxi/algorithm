package com.jason.week5.checkin;

/**
 * 53. 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray {

  public int maxSubArray(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int pre = 0, maxAns = nums[0];
    for (int x : nums) {
      pre = Math.max(pre + x, x);
      maxAns = Math.max(maxAns, pre);
    }
    return maxAns;
  }

  public static void main(String[] args) {
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    MaxSubArray maxSubArray = new MaxSubArray();
    System.out.println(maxSubArray.maxSubArray(nums));
  }

}
