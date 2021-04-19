package com.jason.utils;

/**
 * 工具类
 */
public class Utils {

  public static void printArray(int[] arr) {
    System.out.print("[");
    int len = arr.length;
    for (int i = 0; i < len - 1; i++) {
      System.out.print("" + arr[i] + ", ");
    }
    System.out.println("" + arr[len - 1] + "]");
  }

}
