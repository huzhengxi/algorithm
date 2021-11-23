package com.jason.firsttime;

/**
 * 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * url： https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class AfterTheRain {


  /**
   * 1. 暴力法
   *
   * @param heights
   * @return
   */
  public int trapViolence(int[] heights) {
    int ans = 0;
    int size = heights.length;
    for (int i = 1; i < size - 1; i++) {
      int maxLeft = 0, maxRight = 0;
      //Search the left part for max bar size
      for (int j = i; j >= 0; j--) {
        maxLeft = Math.max(maxLeft, heights[j]);
      }

      //Search the right part for max bar size
      for (int j = i; j < size; j++) {
        maxRight = Math.max(maxRight, heights[j]);
      }
      ans += Math.min(maxLeft, maxRight) - heights[i];
    }
    return ans;
  }

  /**
   * 动态编程
   * @param heights
   * @return
   */
  public int trapDynamic(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }
    int ans = 0;
    int size = heights.length;
    int[] leftMax = new int[size];
    int[] rightMax = new int[size];
    leftMax[0] = heights[0];
    for (int i = 1; i < size; i++) {
      leftMax[i] = Math.max(heights[i], leftMax[i - 1]);
    }
    rightMax[size - 1] = heights[size - 1];
    for (int i = size - 2; i >= 0; i--) {
      rightMax[i] = Math.max(heights[i], rightMax[i + 1]);
    }

    for (int i = 1; i < size - 1; i++) {
      ans += Math.min(leftMax[i], rightMax[i]) - heights[i];
    }
    return ans;
  }


  public static void main(String[] args) {
    int heights[] = new int[]{
        0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
    };
    int heights2[] = new int[]{
        4, 2, 0, 3, 2, 5
    };
    AfterTheRain afterTheRain = new AfterTheRain();
    System.out.println(afterTheRain.trapDynamic(heights));
    System.out.println(afterTheRain.trapDynamic(heights2));
  }
}
