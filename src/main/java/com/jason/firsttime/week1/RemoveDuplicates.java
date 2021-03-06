package com.jason.firsttime.week1;

public class RemoveDuplicates {

  /**
   * 26. 删除排序数组中的重复项
   * <p>
   * 思路：快慢指针 时间复杂度：O(N) 空间复杂度： O(1)
   *
   * @param nums 待操作数组
   * @return 返回新数组的长度
   */
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[i] != nums[j]) {
        nums[++i] = nums[j];
      }
    }
    return i + 1;
  }

}
