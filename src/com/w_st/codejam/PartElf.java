package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Round 1C 2014 Problem A. Part Elf
 */
public class PartElf {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        String[] vida = in.next().split("/");
        System.out.println("Case #" + i + ": " + solve(new BigDecimal(vida[0]), new BigDecimal(vida[1])));
      }
    }
  }

  private static String solve(BigDecimal n, BigDecimal d) {

    BigDecimal q;
    try {
      q = n.divide(d);
    } catch (ArithmeticException e){
      return "impossible";
    }

    BigDecimal frac = new BigDecimal("0.5");
    final BigDecimal divisor = new BigDecimal("2");
    int smallest = Integer.MAX_VALUE;

    for (int i = 1; i <= 40; i++) {
      if (q.compareTo(frac) >= 0) {
        smallest = Math.min(smallest, i);
        if (q.compareTo(frac) == 0) {
          return Integer.toString(smallest);
        }
        q = q.add(frac.negate());
      }
      frac = frac.divide(divisor);
    }
    return "impossible";
  }
}
