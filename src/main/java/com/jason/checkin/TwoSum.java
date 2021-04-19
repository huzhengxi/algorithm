package com.jason.checkin;

import com.jason.utils.Utils;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * <p>
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    if (nums.length == 0) {
      return null;
    }
    //key ：数值， value:数组对应的下标
    Map<Integer, Integer> cacheMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int subtract = target - nums[i];
      if (cacheMap.containsKey(subtract)) {
        return new int[]{cacheMap.get(subtract), i};
      }
      cacheMap.put(nums[i], i);
    }
    return null;
  }

  public static void main(String[] args) {
    int[] nums = {3, 2, 4};
    int target = 6;
    TwoSum twoSum = new TwoSum();
    Utils.printArray(twoSum.twoSum(nums, target));

    int[] nums1 = {3, 3};
    int target1 = 6;
    Utils.printArray(twoSum.twoSum(nums1, target1));
  }
}
