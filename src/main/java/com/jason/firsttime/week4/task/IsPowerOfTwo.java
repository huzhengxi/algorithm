package com.jason.firsttime.week4.task;

/**
 * 231. 2的幂
 */
public class IsPowerOfTwo {

  /**
   * 位运算
   *
   * @param n
   * @return
   */
  public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }

  /**
   * 递归
   *
   * @param n
   * @return
   */
  public boolean isPowerOfTwoRecur(int n) {
    if (n > 0) {
      if (n == 1) {
        return true;
      }
      if (n % 2 == 1) {
        return false;
      }
      return isPowerOfTwo(n / 2);
    }

    return false;
  }


  public static void main(String[] args) {
    IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();
    System.out.println(isPowerOfTwo.isPowerOfTwoRecur(3));
    System.out.println(isPowerOfTwo.isPowerOfTwoRecur(1));
    System.out.println(isPowerOfTwo.isPowerOfTwoRecur(2));
    System.out.println(isPowerOfTwo.isPowerOfTwoRecur(4));
  }
}
