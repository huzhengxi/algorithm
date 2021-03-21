package com.jason.week2.task;

import java.util.Arrays;

/**
 * 455. 分发饼干
 */
public class FindContentChildren {

  /**
   * 贪心法 时间复杂度O(mlogm + nlogn)
   * <p>
   * m = g.length() n = s.length()
   * <p>
   * 两个数组排序的时间复杂度为：O(mlogm + nlogn)
   * <p>
   * 空间复杂度：O(mlogm + nlogn) 空间复杂度的开销主要是来自于排序的额外开销
   *
   * @param g 所有孩子的胃口值数组
   * @param s 目前拥有的所有胃口值的小饼干
   * @return 满足胃口的孩子数量
   */
  public int findContentChildren(int[] g, int[] s) {
    //排序
    Arrays.sort(g);
    Arrays.sort(s);

    int childrenLen = g.length, cookiesLen = s.length, count = 0;

    for (int i = 0, j = 0; i < childrenLen && j < cookiesLen; i++, j++) {
      while (j < cookiesLen && g[i] > s[j]) {
        j++;
      }
      if (j < cookiesLen) {
        count++;
      }
    }
    return count;
  }
}
