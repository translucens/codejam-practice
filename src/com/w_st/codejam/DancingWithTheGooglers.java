package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Qualification Round 2012 Problem B. Dancing With the Googlers
 */
public class DancingWithTheGooglers {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        int n = in.nextInt();
        int s = in.nextInt();
        int p = in.nextInt();
        int[] pts = new int[n];
        for (int j = 0; j < n; j++) {
          pts[j] = in.nextInt();
        }
        System.out.println("Case #" + i + ": " + solve(s, p, pts));
      }
    }
  }

  private static int solve(int s, int p, int[] pts) {
    int greaterP = 0;

    for (int pt : pts) {
      if ((p - 1) * 3 + 1 <= pt) {
        greaterP++;
      } else if (pt == 0 || s == 0) {
        continue;
      } else if (pt == (p - 1) * 3 || pt == (p - 2) * 3 + 2) {
        s--;
        greaterP++;
      }
    }
    return greaterP;
  }
}
