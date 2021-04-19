package com.jason.checkin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * <p>
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    int len = nums.length;
    if (len == 0) {
      return null;
    }
    List<List<Integer>> res = new ArrayList<>();

    //排序
    Arrays.sort(nums);
    for (int i = 0; i < len; i++) {
      //因为数组是排好序的，所以如果当前数字大于0， 则三数之和一定大于0。所以结束循环
      if (nums[i] > 0) {
        break;
      }
      //去重
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int left = i + 1, right = len - 1;
      while (left < right) {
        int sum = nums[i] + nums[right] + nums[left];
        if (sum == 0) {
          res.add(Arrays.asList(nums[i], nums[left], nums[right]));
          //去重
          while (left < right && nums[left] == nums[left + 1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right - 1]) {
            right--;
          }
          left++;
          right--;
        } else if (sum < 0) {
          left++;
        } else if (sum > 0) {
          right--;
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    ThreeSum sum = new ThreeSum();
    List<List<Integer>> res = sum.threeSum(nums);
    for (int i = 0; i < res.size(); i++) {
      System.out.println(res.get(i).toArray().toString());
    }
  }
}
