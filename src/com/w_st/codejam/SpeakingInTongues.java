package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Qualification Round 2012 Problem A. Speaking in Tongues
 */
public class SpeakingInTongues {

  public static void main(String[] args) {
    char[] table = new char[26];
    String[] googlerese =
        {"ejp mysljylc kd kxveddknmc re jsicpdrysi", "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd",
            "de kr kd eoya kw aej tysr re ujdr lkgc jv"};
    String[] strings =
        {"our language is impossible to understand", "there are twenty six factorial possibilities",
            "so it is okay if you want to just give up"};

    for (int i = 0; i < googlerese.length; i++) {
      for (int j = 0; j < googlerese[i].length(); j++) {
        char gc = googlerese[i].charAt(j);
        if (gc != ' ') {
          table[gc - 'a'] = strings[i].charAt(j);
        }
      }
    }
    table['q' - 'a'] = 'z';
    table['z' - 'a'] = 'q';

    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      in.useDelimiter("[\\r\\n]");
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        System.out.println("Case #" + i + ": " + solve(table, in.next()));
      }
    }
  }

  private static String solve(char[] table, String goog) {
    char[] chars = goog.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] != ' ') {
        chars[i] = table[chars[i] - 'a'];
      }
    }
    return String.valueOf(chars);
  }
}
