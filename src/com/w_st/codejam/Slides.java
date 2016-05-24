package com.w_st.codejam;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Round 1C 2016 Problem B. Slides!
 */
public class Slides {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();

      for (int i = 1; i <= testcaseCount; ++i) {
        int b = in.nextInt();
        long m = in.nextLong();
        String[] answer = solve(b, m);
        if (answer.length == 0) {
          System.out.println("Case #" + i + ": IMPOSSIBLE");
        } else {
          System.out.println("Case #" + i + ": POSSIBLE");
          Arrays.asList(answer).forEach(System.out::println);
        }
      }
    }
  }

  private static String[] solve(int b, long m) {
    if ((1L << (b - 2)) < m) {
      return ArrayUtils.EMPTY_STRING_ARRAY;
    }

    int bit = 64 - Long.numberOfLeadingZeros(m);
    String[] answer = new String[b];
    String noSlide = StringUtils.repeat('0', b);
    if (bit == 1) {
      answer[0] = StringUtils.repeat('0', b - 1) + '1';
      for (int i = 1; i < b; i++) {
        answer[i] = noSlide;
      }
      return answer;
    }
    boolean pow2 = m == (1L << (b - 2));

    StringBuilder sb = new StringBuilder(b);
    answer[0] = "0" + StringUtils.repeat('1', bit) + StringUtils.repeat('0', b - bit - 1);

    for (int i = 1; i <= bit; i++) {
      sb.setLength(0);
      sb.append('0');
      sb.append(StringUtils.repeat('0', i));
      sb.append(StringUtils.repeat('1', bit - i));
      if (b - bit > 2) {
        sb.append(StringUtils.repeat('0', b - bit - 2));
      }
      if (!pow2) {
        sb.append((m & (1L << i - 1)) > 0 ? '1' : '0');
      }
      answer[i] = sb.toString();
    }

    for (int i = bit + 1; i < b; i++) {
      answer[i] = noSlide;
    }
    return answer;
  }
}
