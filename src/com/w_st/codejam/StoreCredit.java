package com.w_st.codejam;

import java.util.Scanner;

import com.w_st.codejam.storecredit.TestCase;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Qualification Round Africa 2010 Problem. A
 */
public class StoreCredit {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int N = in.nextInt();
    for (int i = 1; i <= N; ++i) {
      TestCase tc = new TestCase(in);
      System.out.println("Case #" + i + ": " + tc.solve());
    }
  }
}
