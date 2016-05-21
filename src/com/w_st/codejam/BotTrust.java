package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Qualification Round 2011 Problem A. Bot Trust
 */
public class BotTrust {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        int n = in.nextInt();
        char[] r = new char[n];
        int[] p = new int[n];
        for (int j = 0; j < n; j++) {
          r[j] = in.next().charAt(0);
          p[j] = in.nextInt();
        }
        System.out.println("Case #" + i + ": " + solve(r, p));
      }
    }
  }

  private static int solve(char[] r, int[] p) {
    int t = 0;
    int posO = 1;
    int posB = 1;
    int lastPushO = 0;
    int lastPushB = 0;
    for (int i = 0; i < r.length; i++) {

      if (r[i] == 'O') {
        int diffPos = Math.abs(p[i] - posO);
        int diffT = t - lastPushO;
        if (diffPos > diffT) {
          t += diffPos - diffT;
        }
        posO = p[i];
        lastPushO = ++t;
      } else {
        int diffPos = Math.abs(p[i] - posB);
        int diffT = t - lastPushB;
        if (diffPos > diffT) {
          t += diffPos - diffT;
        }
        posB = p[i];
        lastPushB = ++t;
      }
    }
    return t;
  }
}
