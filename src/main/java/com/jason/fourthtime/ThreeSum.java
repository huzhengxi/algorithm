package com.jason.fourthtime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
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
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (len <= 0) {
      return res;
    }
    Arrays.sort(nums);
    for (int first = 0; first < len; first++) {
      if (first > 0 && nums[first] == nums[first - 1]) {
        continue;
      }
      int third = len - 1;
      int target = -nums[first];
      for (int second = first + 1; second < len; second++) {
        if (second > first + 1 && nums[second] == nums[second - 1]) {
          continue;
        }
        while (second < third && nums[second] + nums[third] > target) {
          --third;
        }
        if (second == third) {
          break;
        }
        if (nums[second] + nums[third] == target) {
          List<Integer> list = new ArrayList<>();
          list.add(nums[first]);
          list.add(nums[second]);
          list.add(nums[third]);
          res.add(list);
        }
      }
    }
    return res;
  }


  public static void main(String[] args) {
    ThreeSum threeSum = new ThreeSum();
    int[] nums = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> res = threeSum.threeSum(nums);
    for (int i = 0; i < res.size(); i++) {
      List<Integer> list = res.get(i);
      for (int j = 0; j < list.size(); j++) {
        System.out.print(list.get(j) + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}
