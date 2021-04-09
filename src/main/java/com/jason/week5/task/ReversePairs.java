package com.jason.week5.task;

/**
 * 493. 翻转对
 * <p>
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * <p>
 * 你需要返回给定数组中的重要翻转对的数量。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReversePairs {

  /**
   * 方法：归并排序
   * <p>
   * 时间复杂度 O(NlogN),N为数组的长度
   * <p>
   * 空间复杂度 O(N），N为数组长度
   *
   * @param nums
   * @return
   */
  public int reversePairs(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    return reversePairsMergeSort(nums, 0, nums.length - 1);
  }

  private int reversePairsMergeSort(int[] nums, int left, int right) {
    if (left == right) {
      return 0;
    }

    int mid = left + (right - left) / 2;
    int res = reversePairsMergeSort(nums, left, mid) + reversePairsMergeSort(nums, mid + 1, right);

    //统计下标符合的数量
    int i = left, j = mid + 1;
    while (i <= mid) {
      while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
        j++;
      }
      res += j - mid - 1;
      i++;
    }

    //合并两个排序数组
    int[] sorted = new int[right - left + 1];
    int p1 = left, p2 = mid + 1;
    int p = 0;
    while (p1 <= mid || p2 <= right) {
      if (p1 > mid) {
        sorted[p++] = nums[p2++];
      } else if (p2 > right) {
        sorted[p++] = nums[p1++];
      } else {
        if (nums[p1] < nums[p2]) {
          sorted[p++] = nums[p1++];
        } else {
          sorted[p++] = nums[p2++];
        }
      }
    }

    for (int k = 0; k < sorted.length; k++) {
      nums[left + k] = sorted[k];
    }
    return res;
  }

  public static void main(String[] args) {
    ReversePairs reversePairs = new ReversePairs();
    int[] nums = {1, 3, 2, 3, 1};
    System.out.println(reversePairs.reversePairs(nums));
    int[] nums2 = {2, 4, 3, 5, 1};
    System.out.println(reversePairs.reversePairs(nums2));
  }
}
