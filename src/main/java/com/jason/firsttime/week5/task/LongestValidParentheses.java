package com.jason.firsttime.week5.task;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 * <p>
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class LongestValidParentheses {

  /**
   * 动态规划  时间空间复杂度都为 O(N), N为字符串长度
   *
   * @param s
   * @return
   */
  public int longestValidParentheses(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int maxLen = 0;
    int[] dp = new int[s.length()];
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
        } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
          dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
        }
        maxLen = Math.max(maxLen, dp[i]);
      }
    }
    return maxLen;
  }

  /**
   * 栈  时间复杂度和空间复杂度都为 O(N） N为字符串长度
   *
   * @param s
   * @return
   */
  public int longestValidParenthesesStack(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int maxLen = 0;
    Deque<Integer> stack = new LinkedList<>();
    stack.push(-1);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          maxLen = Math.max(maxLen, i - stack.peek());
        }
      }
    }
    return maxLen;
  }

  public static void main(String[] args) {
    LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
    System.out.println(longestValidParentheses.longestValidParentheses("(()"));
    System.out.println(longestValidParentheses.longestValidParentheses(")()())"));
  }
}
