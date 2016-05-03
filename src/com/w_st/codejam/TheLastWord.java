package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Round 1A 2016 Problem A. The Last Word
 * */
public class TheLastWord {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();
      for (int i = 1; i <= testcaseCount; ++i) {
        System.out.println("Case #" + i + ": " + solve(in.next()));
      }
    }
  }

  private static String solve(String str) {
    StringBuilder sb = new StringBuilder(str.length());
    sb.append(str.charAt(0));
    
    for (int i = 1; i < str.length(); i++) {
      char c = str.charAt(i);
      if (sb.charAt(0) <= c) {
        sb.insert(0, c);
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
