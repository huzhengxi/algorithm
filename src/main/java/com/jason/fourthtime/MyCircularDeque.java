package com.jason.fourthtime;

class DoubleListNode {

  DoubleListNode prev;
  DoubleListNode next;
  int val;

  public DoubleListNode(int val) {
    this.val = val;
  }
}

public class MyCircularDeque {

  int size;
  int k;
  DoubleListNode head;
  DoubleListNode tail;

  public MyCircularDeque(int k) {
    head = new DoubleListNode(-1);
    tail = new DoubleListNode(-1);
    head.prev = tail;
    tail.next = head;
    this.k = k;
    this.size = 0;
  }

  public boolean insertFront(int value) {
    if (size == k) {
      return false;
    }
    DoubleListNode newNode = new DoubleListNode(value);
    newNode.next = head;
    head.prev.next = newNode;
    head.prev = newNode;
    size++;
    return true;
  }

  public boolean deleteFront() {
    if (size == 0) {
      return false;
    }
    head.prev.prev.next = head;
    head.prev = head.prev.prev;
    size--;
    return true;
  }

  public boolean deleteLast() {
    if (size == 0) {
      return false;
    }
    tail.next.next.prev = tail;
    tail.next = tail.next.next;
    size--;
    return true;
  }

  public int getFront() {
    return head.prev.val;
  }

  public int getRear() {
    return tail.next.val;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == k;
  }


}
