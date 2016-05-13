package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Qualification Round 2014 Problem B. Cookie Clicker Alpha
 */
public class CookieClickerAlpha {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {

        double c = in.nextDouble();
        double f = in.nextDouble();
        double x = in.nextDouble();

        System.out.println("Case #" + i + ": " + String.format("%.7f", solve(c, f, x)));
      }
    }
  }

  private static double solve(double c, double f, double x) {
    int n = 0;
    for (; ; n++) {
      if (((x - c) / (2 + f * n)) < (x / (2 + f * (n + 1)))) {
        break;
      }
    }
    double sum = 0.0;
    for (int i = 0; i <= n - 1; i++) {
      sum += c / (2 + f * i);
    }
    sum += x / (2 + f * n);
    return sum;
  }
}
