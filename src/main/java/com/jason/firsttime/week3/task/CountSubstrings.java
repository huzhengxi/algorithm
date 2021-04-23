package com.jason.firsttime.week3.task;

/**
 * 647. 回文子串
 * <p>
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 */
public class CountSubstrings {

  /**
   * 动态规划：
   * <p>
   * dp[i][j] 表示字符串s在[j, i]区间的子串是否为回文字符串
   * <p>
   * dp方程：if(s[i] == s[j] && (i - j < 2 || dp[i -1][j+1])) dp[i][j] = true
   * <p>
   * 时间复杂度和空间复杂度都为：O（n²）
   *
   * @param s
   * @return
   */
  public int countSubstring(String s) {
    int len = s.length();
    if (len == 0) {
      return 0;
    }
    boolean[][] dp = new boolean[len][len];
    int count = 0;
    for (int i = 0; i < len; i++) {
      for (int j = 0; j <= i; j++) {
        if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j + 1])) {
          dp[i][j] = true;
          count++;
        }
      }
    }
    return count;
  }


  public static void main(String[] args) {
    CountSubstrings substrings = new CountSubstrings();
    System.out.println(substrings.countSubstring("aaa"));
  }
}
