package com.jason.week4.task;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 */
public class ClimbStairs {

  /**
   * 动态规划  DP方程为：f(n) = f(n -1) + f(n - 2)
   *
   * @param n
   * @return
   */
  public int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }
    int stepOne = 0, setpTwo = 0, res = 1;
    for (int i = 1; i <= n; i++) {
      stepOne = setpTwo;
      setpTwo = res;
      res = stepOne + setpTwo;
    }
    return res;
  }

  public Map<Integer, Integer> cacheMap = new HashMap<>();

  /**
   * 递归方法
   *
   * @param n
   * @return
   */
  public int climbStairsRecur(int n) {
    return recur(n);
  }

  public int recur(int n) {
    if (n <= 2) {
      return n;
    }

    if (cacheMap.containsKey(n)) {
      return cacheMap.get(n);
    } else {
      int res = recur(n - 1) + recur(n - 2);
      cacheMap.put(n, res);
      return res;
    }
  }

  public static void main(String[] args) {
    ClimbStairs stairs = new ClimbStairs();
    System.out.println(stairs.climbStairs(3));
  }
}
