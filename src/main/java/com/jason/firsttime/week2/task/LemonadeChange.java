package com.jason.firsttime.week2.task;

/**
 * 860. 柠檬水找零
 */
public class LemonadeChange {

  private int five = 0;
  private int ten = 0;


  /**
   * 解法：贪心 时间复杂度：O(n） n为bills的长度
   *
   * @param bills
   * @return 返回找零结果  如果所有顾客都正确找零则返回 true，否则返回false
   */
  public boolean lemonadeChange(int[] bills) {
    for (int bill : bills) {
      if (!dealWith(bill)) {
        return false;
      }
    }
    return true;
  }

  /**
   * 单个顾客找零
   *
   * @param bill 收到单个顾客支付的费用
   * @return 返回找零结果
   */
  private boolean dealWith(int bill) {
    switch (bill) {
      case 5:
        five++;
        break;
      case 10:
        if (five <= 0) {
          return false;
        }
        five--;
        ten++;
        break;
      case 20:
        if (five > 0 && ten > 0) {
          five--;
          ten--;
        } else if (five > 2) {
          five -= 3;
        } else {
          return false;
        }
        break;
      default:
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    LemonadeChange obj = new LemonadeChange();
    int[] bills = {5, 5, 10, 10, 20};
    System.out.println(obj.lemonadeChange(bills));
  }
}
