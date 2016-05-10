package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Round 1A 2015 Problem B. Haircut
 */
public class Haircut {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        int[] barbers = new int[in.nextInt()];
        int place = in.nextInt();

        for (int j = 0; j < barbers.length; j++) {
          barbers[j] = in.nextInt();
        }
        System.out.print("Case #" + i + ": ");
        if (barbers.length <= 5) {
          System.out.println(solveByLcm(barbers, place));
        } else {
          System.out.println(solveByBinary(barbers, place));
        }
      }
    }
  }

  private static int solveByLcm(int[] barbers, int place) {
    if (barbers.length == 1) {
      return 1;
    }

    int cm = lcm(barbers[0], barbers[1]);
    for (int i = 2; i < barbers.length; i++) {
      cm = lcm(cm, barbers[i]);
    }
    int lcm = cm;
    int customerInLcm = Arrays.stream(barbers).map(b -> lcm / b).sum();

    int myPlace = place % customerInLcm;
    return solveBySimulation(barbers, myPlace == 0 ? customerInLcm : myPlace);
  }

  private static int lcm(int a, int b) {
    return a * b / gcd(a, b);
  }

  private static int gcd(int a, int b) {
    int x;
    while (a % b != 0) {
      x = b;
      b = a % b;
      a = x;
    }
    return b;
  }

  private static int solveBySimulation(int[] barbers, int place) {
    int customer = 0;
    for (int t = 0; ; t++) {
      for (int i = 0; i < barbers.length; ++i) {
        if (t % barbers[i] == 0) {
          ++customer;
        }
        if (customer == place) {
          return i + 1;
        }
      }
    }
  }

  private static int solveByBinary(int[] barbers, int place) {
    throw new RuntimeException("Need implementation!");
  }
}
