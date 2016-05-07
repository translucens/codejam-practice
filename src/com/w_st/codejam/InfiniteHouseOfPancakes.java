package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Qualification Round 2015 Problem B. Infinite House of Pancakes
 */
public class InfiniteHouseOfPancakes {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();
      for (int i = 1; i <= testcaseCount; ++i) {
        System.out.println("Case #" + i + ": " + solve(in.nextInt(), in));
      }
    }
  }

  private static int solve(int diners, Scanner in) {
    int[] pancakes = new int[diners];
    for (int i = 0; i < diners; i++) {
      pancakes[i] = in.nextInt();
    }

    Arrays.sort(pancakes);

    int max = pancakes[pancakes.length - 1];
    int minMinutes = max;
    for (int threthold = 1; threthold < max; threthold++) {
      int minutes = 0;
      for (int i = pancakes.length - 1; i >= 0; i--) {
        if (pancakes[i] <= threthold) {
          break;
        }
        minutes += Math.ceil(pancakes[i] / (double)threthold) - 1;
      }
      minMinutes = Math.min(minMinutes, minutes + threthold);
    }

    return minMinutes;
  }
}
