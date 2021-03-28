package com.jason.week3.checkin;

/**
 * 1143. 最长公共子序列
 */
public class LongestCommonSubsequence {

  /**
   * 状态转移方程：
   * <p>
   * 1.如果text1第i个字符和text2的第j个元素相等，那么dp[i][j]就为dp[i-1][j-1] + 1
   * <p>
   * 2.如果text1第i个字符和text2的第j个元素不相等，那么dp[i][j]就为d[i-1][j]接d[i][j-1]的最大者，即：
   * <p>
   * dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]
   *
   * @param text1
   * @param text2
   * @return
   */
  public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length(), n = text2.length();
    if (m == 0 || n == 0) {
      return 0;
    }
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
      }
    }
    return dp[m][n];
  }
}
