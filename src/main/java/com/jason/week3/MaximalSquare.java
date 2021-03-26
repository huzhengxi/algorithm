package com.jason.week3;

/**
 * 221. 最大正方形 https://leetcode-cn.com/problems/maximal-square/
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
