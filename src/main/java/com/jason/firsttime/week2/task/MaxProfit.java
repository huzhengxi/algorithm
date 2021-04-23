package com.jason.firsttime.week2.task;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class MaxProfit {

  /**
   * 贪心算法 时间复杂度：O(n）
   *
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) {
    int len = prices.length;
    if (len < 2) {
      return 0;
    }
    int res = 0;

    for (int i = 1; i < len; i++) {
      if (prices[i] - prices[i - 1] > 0) {
        res += prices[i] - prices[i - 1];
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int prices[] = {7, 6, 4, 3, 1};
    MaxProfit maxProfit = new MaxProfit();
    System.out.println(maxProfit.maxProfit(prices));

  }
}
