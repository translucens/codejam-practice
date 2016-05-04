package com.w_st.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

/**
 * Round 1B 2016 Problem A. Getting the Digits
 * */
public class GettingTheDigits {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int testcaseCount = in.nextInt();
      for (int i = 1; i <= testcaseCount; ++i) {
        System.out.println("Case #" + i + ": " + solve(in.next()));
      }
    }
  }

  private static String solve(String str) {
    Map<Character, Integer> count = new HashMap<>();
    char[] chars =
        {'Z', 'E', 'R', 'O', 'N', 'T', 'W', 'H', 'E', 'F', 'U', 'I', 'V', 'S', 'X', 'V', 'G'};
    for (char c : chars) {
      count.put(Character.valueOf(c), Integer.valueOf(0));
    }

    for (char c : str.toCharArray()) {
      Character ch = Character.valueOf(c);
      count.put(ch, Integer.valueOf(count.get(ch).intValue() + 1));
    }
    int[] digit = new int[10];
    int zero = count.get(Character.valueOf('Z')).intValue();
    digit[0] = zero;
    count.put('E', count.get('E') - zero);
    count.put('R', count.get('R') - zero);
    count.put('O', count.get('O') - zero);

    int two = count.get(Character.valueOf('W')).intValue();
    digit[2] = two;
    count.put('T', count.get('T') - two);
    count.put('O', count.get('O') - two);

    int four = count.get(Character.valueOf('U')).intValue();
    digit[4] = four;
    count.put('F', count.get('F') - four);
    count.put('O', count.get('O') - four);
    count.put('R', count.get('R') - four);

    int six = count.get(Character.valueOf('X')).intValue();
    digit[6] = six;
    count.put('S', count.get('S') - six);
    count.put('I', count.get('I') - six);

    int eight = count.get(Character.valueOf('G')).intValue();
    digit[8] = eight;
    count.put('E', count.get('E') - eight);
    count.put('I', count.get('I') - eight);
    count.put('H', count.get('H') - eight);
    count.put('T', count.get('T') - eight);

    int one = count.get(Character.valueOf('O')).intValue();
    digit[1] = one;

    int three = count.get(Character.valueOf('T')).intValue();
    digit[3] = three;

    int five = count.get(Character.valueOf('F')).intValue();
    digit[5] = five;
    count.put('I', count.get('I') - five);

    int seven = count.get(Character.valueOf('S')).intValue();
    digit[7] = seven;

    int nine = count.get(Character.valueOf('I')).intValue();
    digit[9] = nine;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < digit.length; i++) {
      sb.append(StringUtils.repeat(Character.forDigit(i, 10), digit[i]));
    }
    return sb.toString();
  }
}
