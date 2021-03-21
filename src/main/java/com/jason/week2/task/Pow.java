package com.jason.week2.task;

/**
 * 50.Pow(x, n)
 * 思路：分治
 */
public class Pow {

  public double subProblem(double x, int n) {
    if (n == 0) {
      return 1.0;
    }
    double temp = subProblem(x, n / 2);
    return n % 2 == 0 ? temp * temp : temp * temp * x;
  }

  public double myPow(double x, int n) {
    return n >= 0 ? subProblem(x, n) : 1.0 / subProblem(x, -n);
  }

  public static void main(String[] args) {
    double x = 2.0;
    Pow obj = new Pow();
    System.out.println(obj.myPow(x, -2));
  }
}


