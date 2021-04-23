package com.jason.firsttime.week3.task;

/**
 * 64. 最小路径和 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 例子1：
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * <p>
 * 输出：7  解释：因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 例子2： 输入：grid = [[1,2,3],[4,5,6]]
 * <p>
 * 输出：12
 */
public class MinPathSum {

  /**
   * DP 方程：dp[i][j] = Math.min(dp[i - 1][j], dp[i][j-1]) + dp[i][j]
   * <p>
   * 解释：走到第i行j列的最小路径为：从第i-1行向下走一步和从第j-1列向右走一步中最小值
   *
   * @param grid
   * @return
   */
  public int minPathSub(int[][] grid) {
    int lenRow = grid.length;
    if (lenRow <= 0) {
      return 0;
    }
    int lenCol = grid[0].length;
    for (int i = 0; i < lenRow; i++) {
      for (int j = 0; j < lenCol; j++) {
        //第0行0列最小值为本身，所以不做处理
        if (i == 0 && j == 0) {
          continue;
        } else if (i == 0) {
          //第0行j列最小值为从前一列向右走一步
          grid[i][j] = grid[i][j - 1] + grid[i][j];
        } else if (j == 0) {
          //第i行0列最小值为从前一行向下走一步
          grid[i][j] = grid[i - 1][j] + grid[i][j];
        } else {
          grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
        }
      }
    }
    return grid[lenRow - 1][lenCol - 1];
  }


  public static void main(String[] args) {
    MinPathSum minPathSum = new MinPathSum();
    int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    System.out.println(minPathSum.minPathSub(grid));
    int[][] grid1 = {{1, 2, 3}, {4, 5, 6}};
    System.out.println(minPathSum.minPathSub(grid1));
  }
}
