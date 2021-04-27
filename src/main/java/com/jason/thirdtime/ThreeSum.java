package com.jason.thirdtime;

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

  /**
   * 双指针法 时间复杂度O(n2)  空间复杂度O(logN)
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> threeSum(int[] nums) {
    int len = nums.length;
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    if (len <= 0) {
      return ans;
    }
    Arrays.sort(nums);
    //枚举a
    for (int first = 0; first < len; first++) {
      //需要和上次枚举的数不相同
      if (first > 0 && nums[first] == nums[first - 1]) {
        continue;
      }

      //c 对应的指针初始指向数组的最右端
      int third = len - 1;
      //a + b + c = 0的话， b + c = -a，这里的b+c就是下面的target
      int target = -nums[first];
      //枚举b
      for (int second = first + 1; second < len; second++) {
        //需要和上次枚举的不相同
        if (second > first + 1 && nums[second] == nums[second - 1]) {
          continue;
        }
        //需要保证b的指针在c的指针的左侧
        while (second < third && nums[second] + nums[third] > target) {
          --third;
        }
        //如果指针重合，随着 b 后续的增加，就不会有满足 a + b +c = 0 并且 b < c 的 c 了，可以退出循环
        if (second == third) {
          break;
        }
        if (nums[second] + nums[third] == target) {
          List<Integer> list = new ArrayList<>();
          list.add(nums[first]);
          list.add(nums[second]);
          list.add(nums[third]);
          ans.add(list);
        }
      }
    }
    return ans;
  }


  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    ThreeSum sum = new ThreeSum();
    List<List<Integer>> res = sum.threeSum(nums);
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
