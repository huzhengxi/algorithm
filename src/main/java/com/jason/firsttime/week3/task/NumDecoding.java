package com.jason.firsttime.week3.task;

/**
 * 91. 解码方法 https://leetcode-cn.com/problems/decode-ways/
 */
public class NumDecoding {

  public int numDecoding(String s) {
    int len = s.length();
    if (len == 0 || s.charAt(0) == 0) {
      return 0;
    }
    int[] dp = new int[len];
    dp[0] = 1;

    for (int i = 1; i < len; i++) {
      if (s.charAt(i) == '0') {
        //如果出现0， 并且0前面不是1或者2的话，不能解码
        if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
          return 0;
        }
        dp[i] = i == 1 ? 1 : dp[i - 2];
      } else if (s.charAt(i - 1) == '1' ||
          (s.charAt(i - 1) == '2' && s.charAt(i) - '0' > 0 && s.charAt(i) - '0' < 7)) {
        dp[i] = i == 1 ? dp[i - 1] + 1 : dp[i - 1] + dp[i - 2];
      } else {
        //只有一种解码
        dp[i] = dp[i - 1];
      }
    }
    return dp[len - 1];
  }

  public static void main(String[] args) {
    NumDecoding decoding = new NumDecoding();
    System.out.println(decoding.numDecoding("10"));
  }
}
