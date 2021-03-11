package com.jason.utils.listutil;

/**
 * 列表工具类
 */
public class ListUtil {

  /**
   * 根据传入的数组创建出一个链表
   *
   * @param arr
   * @return
   */
  public static ListNode createLinkedList(int[] arr) {
    if (arr.length == 0) {
      return null;
    }
    ListNode head = new ListNode(arr[0]);
    ListNode current = head;
    for (int i = 1; i < arr.length; i++) {
      current.next = new ListNode(arr[i]);
      current = current.next;
    }
    return head;
  }


  /**
   * 打印一个链表
   *
   * @param head
   */
  public static void printLinkedList(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.printf("%d -> ", current.val);
      current = current.next;
    }
    System.out.println("NULl");
  }
}
