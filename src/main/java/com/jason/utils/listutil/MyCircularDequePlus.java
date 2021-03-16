package com.jason.utils.listutil;

/**
 * 641. 设计循环双端队列
 */
public class MyCircularDequePlus {

  private int[] circle;
  private int headIndex;
  private int tailIndex;
  private int length;

  public MyCircularDequePlus(int length) {
    this.length = length + 1;
    circle = new int[length];
  }

  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    }
    headIndex = (headIndex - 1 + length) % length;
    circle[headIndex] = value;
    return true;
  }

  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    }
    circle[tailIndex] = value;
    tailIndex = (tailIndex + 1) % length;
    return true;
  }

  public boolean deleteFront() {
    if (isEmpty()) {
      return false;
    }
    headIndex = (headIndex + 1 + length) % length;
    return true;
  }

  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    }
    tailIndex = (tailIndex - 1 + length) % length;
    return true;
  }

  public int getFront() {
    if (isEmpty()) {
      return -1;
    }
    return circle[headIndex];
  }

  public int getRear() {
    if (isEmpty()) {
      return -1;
    }
    return circle[(tailIndex - 1 + length) % length];
  }


  public boolean isEmpty() {
    return headIndex == tailIndex;
  }

  public boolean isFull() {
    return headIndex == (tailIndex + 1) % length;
  }

}
