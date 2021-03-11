package com.jason.week1;

import com.jason.utils.Utils;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 */
public class TwoSum {

  public static int[] twoSum(int[] nums, int target) {
    if (nums.length == 0) {
      return null;
    }
    Map<Integer, Integer> cacheMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (cacheMap.containsKey(target - nums[i])) {
        return new int[]{cacheMap.get(target - nums[i]), i};
      }
      cacheMap.put(nums[i], i);
    }
    return null;
  }

  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    int res[] = TwoSum.twoSum(nums, target);
    Utils.printArray(res);

    Utils.printArray(TwoSum.twoSum(new int[]{3, 2, 4}, 6));
    Utils.printArray(TwoSum.twoSum(new int[]{3, 3}, 6));
  }

}
