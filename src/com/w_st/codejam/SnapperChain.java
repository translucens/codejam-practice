package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Qualification Round 2010 Problem A. Snapper Chain
 */
public class SnapperChain {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println("Case #" + i + ": " + solve(n, k));
      }
    }
  }

  private static String solve(int n, int k) {
    k &= (1 << n) - 1;
    int on = Integer.bitCount(k);
    return (on == n) ? "ON" : "OFF";
  }
}
