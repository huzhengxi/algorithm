package com.jason.week3.task;

/**
 * 32. 最长有效括号
 * <p>
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 */
public class LongestValidParentheses {

  /**
   * 方法一：动态规划
   * <p>
   * 状态转移方程为：dp[i]=(2 + dp[i−1]) + dp[i−dp[i−1]−2]
   *
   * @param s
   * @return
   */
  public int longestValidParentheses(String s) {
    int len = s.length();
    if (len == 0) {
      return 0;
    }
    int maxLength = 0;
    int[] dp = new int[len];
    for (int i = 1; i < len; i++) {
      //如果为左括号的话 有效长度为0
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
        } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
          dp[i] = dp[i - 1] + ((i - dp[i - 1] >= 2) ? dp[i - dp[i - 1] - 2] : 0);
        }
        maxLength = Math.max(maxLength, dp[i]);
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {
    LongestValidParentheses validParentheses = new LongestValidParentheses();
    System.out.println(validParentheses.longestValidParentheses("(()"));
    System.out.println(validParentheses.longestValidParentheses(")()())"));
    System.out.println(validParentheses.longestValidParentheses(""));
  }
}
