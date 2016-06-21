package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Round 1C 2015 Problem A. Brattleship
 */
public class Brattleship {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        int r = in.nextInt();
        int c = in.nextInt();
        int w = in.nextInt();
        System.out.println("Case #" + i + ": " + solve(r, c, w));
      }
    }
  }

  private static int solve(int r, int c, int w) {
    if (r == 1) {
      return solve(c, w);
    } else {
      return (r - 1) * (c / w) + solve(c, w);
    }
  }

  private static int solve(int c, int w) {
    if (c - 1 <= w || w == 1) {
      return c;
    }
    if (w * 2 <= c) {
      return 1 + solve(c - w, w);
    }
    int overlap = 2 * w - c;
    return overlap + solve(c - overlap, w - overlap);
  }
}
