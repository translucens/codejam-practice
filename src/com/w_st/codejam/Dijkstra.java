package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Qualification Round 2015 Problem C. Dijkstra
 */
public class Dijkstra {

  // 1:1, i:2, j:3, k:4
  private static int[][] multiplyTable =
      {{}, {0, 1, 2, 3, 4}, {0, 2, -1, 4, -3}, {0, 3, -4, -1, 2}, {0, 4, 3, -2, -1}};

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();
      for (int i = 1; i <= testcaseCount; ++i) {

        in.nextInt(); // length
        System.out.println("Case #" + i + ": " + solve(in.nextLong(), in.next()));
      }
    }
  }

  private static String solve(long repeat, String str) {

    int[] encodedStr = encodeString(str);
    int m = multiplyString(encodedStr);
    int mPowerX = power(m, repeat);
    if (mPowerX != -1) {
      return "NO";
    }

    return findIAndJ(repeat, encodedStr) ? "YES" : "NO";
  }

  private static boolean findIAndJ(long repeat, int[] encodedStr) {
    repeat = Math.min(repeat, 4 * 2);
    int product = 1;
    boolean foundI = false;
    int finding = 2;
    for (int i = 0; i < repeat; i++) {
      for (int j = 0; j < encodedStr.length; j++) {
        product = multiply(product, encodedStr[j]);
        if (product == 2 && !foundI) {
          foundI = true;
          product = 1;
        } else if (product == 3 && foundI) {
          return true;
        }
      }
    }
    return false;
  }

  private static int power(int m, long repeat) {
    repeat = repeat % 4;

    int powered = 1;
    for (int i = 0; i < repeat; i++) {
      powered = multiply(powered, m);
    }
    return powered;
  }

  private static int[] encodeString(String str) {
    int[] encodedStr = new int[str.length()];
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      encodedStr[i] = c == 'i' ? 2 : c == 'j' ? 3 : 4;
    }
    return encodedStr;
  }

  private static int multiplyString(int[] str) {
    int m = 1;
    for (int i = 0; i < str.length; i++) {
      m = multiply(m, str[i]);
    }
    return m;
  }

  private static int multiply(int l, int r) {
    if (l > 0) {
      if (r > 0) {
        return multiplyTable[l][r];
      } else {
        return -multiplyTable[l][-r];
      }
    } else {
      if (r > 0) {
        return -multiplyTable[-l][r];
      } else {
        return multiplyTable[-l][-r];
      }
    }
  }
}
