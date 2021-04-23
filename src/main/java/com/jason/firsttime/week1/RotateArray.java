package com.jason.firsttime.week1;

/**
 * 189.旋转数组
 */
public class RotateArray {

  public void rotate(int[] nums, int k) {
    int len = nums.length;
    int[] newArr = new int[len];
    for (int i = 0; i < len; i++) {
      int index = (i + k) % len;
      newArr[index] = nums[i];
    }
    System.arraycopy(newArr, 0, nums, 0, len);
  }

  public static void printArray(int[] arr, String tips) {
    System.out.print(tips + ":[");
    int len = arr.length;
    for (int i = 0; i < len - 1; i++) {
      System.out.print("" + arr[i] + ", ");
    }
    System.out.println("" + arr[len - 1] + "]");
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    RotateArray rotateArray = new RotateArray();
    RotateArray.printArray(nums, "输入：");
    rotateArray.rotate(nums, 3);
    RotateArray.printArray(nums, "输出");

    int[] nums2 = {-1, -100, 3, 99};
    int k2 = 2;
    System.out.println("");
    RotateArray.printArray(nums2, "输入");
    rotateArray.rotate(nums2, k2);
    RotateArray.printArray(nums2, "输出");
  }
}
