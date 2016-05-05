package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Qualification Round 2015 Problem A. Standing Ovation
 */
public class StandingOvation {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();
      for (int i = 1; i <= testcaseCount; ++i) {
        System.out.println("Case #" + i + ": " + solve(in.nextInt(), in.next()));
      }
    }
  }

  private static int solve(int max, String audience) {
    int sum = 0;
    int invite = 0;

    for (int i = 0; i < audience.length(); i++) {
      int ithGuest = Character.digit(audience.charAt(i), 10);
      if (ithGuest == 0) {
        continue;
      }
      if (sum < i) {
        invite += i - sum;
        sum += i - sum;
      }
      sum += ithGuest;
    }
    return invite;
  }
}
