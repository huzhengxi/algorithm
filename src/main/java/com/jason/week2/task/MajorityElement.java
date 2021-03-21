package com.jason.week2.task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 */
public class MajorityElement {

  /**
   * 方法一：直接排序 取中间的值 时间复杂度为：n 时间负载：nlogn（也就是排序算法的时间复杂度）
   *
   * @param nums
   * @return
   */
  public int majorityElementBySort(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }

  /**
   * 方法二：哈希表 时间复杂度：O(n)
   *
   * @param nums
   * @return
   */
  public int majorityElementByHashMap(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    //统计每个元素出现的次数  key:数字，value：数字出现的次数
    Map<Integer, Integer> numsCount = new HashMap<>();
    for (int num : nums) {
      if (!numsCount.containsKey(num)) {
        numsCount.put(num, 1);
      } else {
        numsCount.put(num, numsCount.get(num) + 1);
      }
    }

    Map.Entry<Integer, Integer> entry = null;
    for (Map.Entry<Integer, Integer> en : numsCount.entrySet()) {
      if (entry == null || entry.getValue() < en.getValue()) {
        entry = en;
      }
    }
    return entry.getKey();
  }

  /**
   * 方法三：摩尔投票 时间复杂度：O(n）
   *
   * @param nums
   * @return
   */
  public int majorityElementByVote(int[] nums) {
    int count = 0;
    Integer majorityElement = null;
    for (int num : nums) {
      if (count == 0) {
        majorityElement = num;
      }
      count += num == majorityElement ? 1 : -1;
    }
    return majorityElement;
  }

  /**
   * 分治 时间复杂度：O(nlogn)
   *
   * @param nums
   * @return
   */
  public int  majorityElementByDivide(int[] nums) {
    return divide(nums, 0, nums.length - 1);
  }

  private int divide(int[] nums, int low, int high) {

    if (low == high) {
      return nums[low];
    }

    int mid = low + (high - low) / 2;
    int left = divide(nums, low, mid);
    int right = divide(nums, mid + 1, high);

    if (left == right) {
      return left;
    }

    int leftCount = getNumCountInRange(nums, left, low, high);
    int rightCount = getNumCountInRange(nums, right, low, high);

    return leftCount > rightCount ? left : right;
  }

  private int getNumCountInRange(int[] nums, int num, int low, int high) {
    int count = 0;
    for (int i = low; i <= high; i++) {
      if (nums[i] == num) {
        count++;
      }
    }
    return count;
  }


  public static void main(String[] args) {
    MajorityElement obj = new MajorityElement();
    int testArr[] = {1, 5, 6, 7, 8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7};
    System.out.println(obj.majorityElementByDivide(testArr));
  }
}
