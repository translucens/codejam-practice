package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Round 2 2014 Problem B. Up and Down
 */
public class UpAndDown {

  public static void main(String[] args) {

    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        int n = in.nextInt();
        List<Integer> ints = new LinkedList<>();
        for (int j = 0; j < n; j++) {
          ints.add(in.nextInt());
        }
        System.out.println("Case #" + i + ": " + solve(ints));
      }
    }
  }

  private static int solve(List<Integer> ints) {

    int swap = 0;
    while (!ints.isEmpty()) {
      int index = 0;
      int minIndex = 0;
      int min = Integer.MAX_VALUE;
      for (Integer a : ints) {
        if (a < min) {
          minIndex = index;
          min = a;
        }
        index++;
      }
      swap += Math.min(minIndex, ints.size() - minIndex - 1);
      ints.remove(minIndex);
    }
    return swap;
  }
}
