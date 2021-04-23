package com.jason.firsttime.week3.task;

/**
 * 221. 最大正方形 https://leetcode-cn.com/problems/maximal-square/
 * <p>
 * dp方程：dp[i][j] = Math.min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1 如果
 * matrix[i][j]为1，则以此为右下角的正方形的最大边长为：上面正方形、左边正方形和左上方的正方形中，最小的那个再加上1
 * <p>
 * 时间复杂度和空间复杂度都为 O（mn） m、n为二维数组的行和列
 */
public class MaximalSquare {

  public int maximalSquare(char[][] matrix) {
    int maxSize = 0;
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return maxSize;
    }
    int rows = matrix.length, cols = matrix[0].length;
    int[][] dp = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (matrix[i][j] == '1') {
          if (i == 0 || j == 0) {
            dp[i][j] = 1;
          } else {
            //上面正方形、左边正方形和左上方的正方形中，最小的那个再加上1
            dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
          }
          maxSize = Math.max(maxSize, dp[i][j]);
        }
      }
    }
    return maxSize * maxSize;
  }


  public static void main(String[] args) {
    char[][] matrix = {{'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}};
    MaximalSquare maximalSquare = new MaximalSquare();
    System.out.println(maximalSquare.maximalSquare(matrix));
    char[][] matrix2 = {{'0', '1'},
        {'1', '0'}
    };
    System.out.println(maximalSquare.maximalSquare(matrix2));
    char[][] matrix3 = {{'0'}};
    System.out.println(maximalSquare.maximalSquare(matrix3));
  }
}
