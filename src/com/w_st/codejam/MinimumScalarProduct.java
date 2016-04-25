package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.w_st.codejam.scalarproduct.TestCase;

/**
 * Round 1A 2008 Problem A. Minimum Scalar Product
 */
public class MinimumScalarProduct {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();
    for (int i = 1; i <= T; ++i) {
      TestCase tc = new TestCase(in);
      System.out.println("Case #" + i + ": " + tc.minimumProduct());
    }
  }
}
