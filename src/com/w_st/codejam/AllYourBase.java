package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Round 1C 2009 Problem A. All Your Base
 */
public class AllYourBase {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();
      for (int i = 1; i <= testcaseCount; ++i) {
        System.out.println("Case #" + i + ": " + solve(in.next()));
      }
    }
  }

  private static long solve(String symbols) {
    Map<Character, Integer> translationTable = new HashMap<>(symbols.length());
    int radix = 0;
    int[] translated = new int[symbols.length()];

    for (int i = 0; i < translated.length; i++) {
      Character symbol = Character.valueOf(symbols.charAt(i));
      Integer translatedChar = translationTable.get(symbol);
      if (translatedChar != null) {
        translated[i] = translatedChar.intValue();
        continue;
      }

      int tr = radix == 0 ? 1 : radix == 1 ? 0 : radix;
      translationTable.put(symbol, tr);
      translated[i] = tr;
      ++radix;
    }

    if (radix == 1) {
      radix = 2;
    }

    long result = 0L;
    long base = 1L;
    for (int i = translated.length - 1; 0 <= i; i--) {
      result += translated[i] * base;
      base *= radix;
    }
    return result;
  }
}
