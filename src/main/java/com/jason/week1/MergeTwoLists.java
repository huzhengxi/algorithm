package com.jason.week1;

import com.jason.utils.ListNode;
import com.jason.utils.Utils;

/**
 * 21. 合并两个有序链表
 */
public class MergeTwoLists {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode pre = new ListNode(0);
    ListNode cur = new ListNode(0);
    pre.next = cur;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        cur.next = new ListNode(l1.val);
        l1 = l1.next;
      } else {
        cur.next = new ListNode(l2.val);
        l2 = l2.next;
      }
      cur = cur.next;
    }
    cur.next = l1 == null ? l2 : l1;
    return pre.next.next;
  }

  public static void main(String[] args) {
    int[] l1 = {1, 2, 4};
    int[] l2 = {1, 3, 4};
    MergeTwoLists merge = new MergeTwoLists();
    ListNode mergeNode = merge
        .mergeTwoLists(Utils.createLinkedList(l1), Utils.createLinkedList(l2));
    Utils.printLinkedList(mergeNode);
  }
}
