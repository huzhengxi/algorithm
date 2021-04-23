package com.jason.firsttime.week3.task;

/**
 * 72. 编辑距离
 * <p>
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符 删除一个字符 替换一个字符
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDistance {

  public int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    if (m * n == 0) {
      return m + n;
    }
    int[][] dp = new int[m + 1][n + 1];
    //初始化
    for (int i = 1; i <= m; i++) {
      dp[i][0] = i;
    }

    for (int i = 1; i <= n; i++) {
      dp[0][i] = i;
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
        }
      }
    }
    return dp[m][n];
  }


  public static void main(String[] args) {
    MinDistance minDistance = new MinDistance();
    System.out.println(minDistance.minDistance("horse", "ros"));
    System.out.println(minDistance.minDistance("intention", "execution"));
  }

}
