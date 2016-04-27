package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * Round 1C 2010 Problem A. Rope Intranet
 * */
public class RopeIntranet {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCaseCount = in.nextInt();
    for (int i = 1; i <= testCaseCount; ++i) {
      System.out.println("Case #" + i + ": " + solve(in));
    }
  }

  private static int solve(Scanner in) {
    int wireCount = in.nextInt();
    int[] a = new int[wireCount];
    int[] b = new int[wireCount];
    for (int i = 0; i < wireCount; i++) {
      a[i] = in.nextInt();
      b[i] = in.nextInt();
    }

    int intersection = 0;
    for (int i = 0; i < wireCount; i++) {
      for (int j = i + 1; j < wireCount; j++) {
        if ((a[i] - a[j]) * (b[i] - b[j]) < 0) {
          ++intersection;
        }
      }
    }
    return intersection;
  }
}
