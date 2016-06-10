package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Round 1B 2015 Problem B. Noisy Neighbors
 */
public class NoisyNeighbors {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        int r = in.nextInt();
        int c = in.nextInt();
        System.out
            .println("Case #" + i + ": " + solve(Math.min(r, c), Math.max(r, c), in.nextInt()));
      }
    }
  }

  private static int solve(int r, int c, int n) {
    boolean odd = (r % 2 != 0) && (c % 2 != 0);
    int maxHappyCapacity = odd ? (r * c + 1) / 2 : r * c / 2;
    if (n <= maxHappyCapacity) {
      return 0;
    }

    if (r == 1) {
      if (odd) {
        return Math.min(calcUnhappiness(n - maxHappyCapacity, 0, c - maxHappyCapacity, 0),
            calcUnhappiness(n - maxHappyCapacity + 1, 2, r - maxHappyCapacity - 1, 0));
      }
      return calcUnhappiness(n - maxHappyCapacity, 1, c / 2 - 1, 0);
    }

    if (!odd) {
      return calcUnhappiness(n - maxHappyCapacity, 0, 2, r + c - 4);
    }

    return Math.min(calcUnhappiness(n - maxHappyCapacity + 1, 0, 4, r + c - 6),
        calcUnhappiness(n - maxHappyCapacity, 0, 0, r + c - 2));
  }

  private static int calcUnhappiness(int n, int one, int two, int three) {

    int unhappiness = Math.min(one, n);
    if (n <= one) {
      return unhappiness;
    }
    n -= one;
    unhappiness += 2 * Math.min(two, n);
    if (n <= two) {
      return unhappiness;
    }
    n -= two;
    unhappiness += 3 * Math.min(three, n);
    if (n <= three) {
      return unhappiness;
    }
    n -= three;
    return unhappiness + 4 * n;
  }
}
