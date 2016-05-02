package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RevengeOfThePancakes {

  /**
   * Qualification Round 2016 Problem B. Revenge of the Pancakes
   */
  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();
      for (int i = 1; i <= testcaseCount; ++i) {
        System.out.println("Case #" + i + ": " + solve(in.next()));
      }
    }
  }

  private static int solve(String next) {
    char[] symbols = next.toCharArray();
    int flip = symbols[symbols.length - 1] == '-' ? 1 : 0;
    for (int i = 0; i < symbols.length - 1; i++) {
      if (symbols[i] != symbols[i + 1]) {
        ++flip;
      }
    }
    return flip;
  }
}
