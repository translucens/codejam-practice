package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Round 1A 2015 Problem A. Mushroom Monster
 */
public class MushroomMonster {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        int[] mushrooms = new int[in.nextInt()];

        mushrooms[0] = in.nextInt();
        int count1st = 0;
        int maxDiff = 0;
        for (int j = 1; j < mushrooms.length; j++) {
          mushrooms[j] = in.nextInt();
          int diff = mushrooms[j - 1] - mushrooms[j];
          maxDiff = Math.max(maxDiff, diff);
          if (diff > 0) {
            count1st += diff;
          }
        }
        System.out.println("Case #" + i + ": " + count1st + ' ' + solve2nd(mushrooms, maxDiff));
      }
    }
  }

  private static int solve2nd(int[] mushrooms, int maxDiff) {
    return Arrays.stream(mushrooms).limit(mushrooms.length - 1).map(m -> Math.min(m, maxDiff))
        .sum();
  }
}
