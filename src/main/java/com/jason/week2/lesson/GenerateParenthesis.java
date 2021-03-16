package com.jason.week2.lesson;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class GenerateParenthesis {


  private List<String> result;

  //递归
  public List<String> generateParenthesis(int n) {
    result = new ArrayList<>();
    _generate(0, 0, n, "");
    return result;
  }

  private void _generate(int left, int right, int n, String s) {
    if (left == n && right == n) {
      result.add(s);
      return;
    }

    //思想：左括号的个数>右括号的个数。左括号随时都可以加只要个数小于n，
    // 右括号加之前 必须有左括号 且左括号的个数大于右括号
    if (left < n) {
      _generate(left + 1, right, n, s + "(");
    }

    if (left > right) {
      _generate(left, right + 1, n, s + ")");
    }
  }


  public static void main(String[] args) {
    GenerateParenthesis obj = new GenerateParenthesis();
    System.out.println(obj.generateParenthesis(3));
  }

}
