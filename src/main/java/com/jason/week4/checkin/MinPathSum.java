package com.jason.week4.checkin;

/**
 * 64. 最小路径和
 * <p>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 */
public class MinPathSum {

  /**
   * 时间复杂度O(M*N）   空间复杂度 O(1）
   *
   * @param grid
   * @return
   */
  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return -1;
    }
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (i == 0 && j == 0) { //grid[0][0]不变
          continue;
        } else if (i == 0) { //第一行
          grid[i][j] = grid[i][j - 1] + grid[i][j];
        } else if (j == 0) {//第一列
          grid[i][j] = grid[i - 1][j] + grid[i][j];
        } else {
          grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
        }
      }
    }
    return grid[grid.length - 1][grid[0].length - 1];
  }

  public static void main(String[] args) {
    MinPathSum minPathSum = new MinPathSum();
    int[][] grid = {
        {1, 2, 3},
        {4, 5, 6}
    };
    System.out.println(minPathSum.minPathSum(grid));
  }
}
