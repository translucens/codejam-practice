package com.w_st.codejam.storecredit;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestCase {
  int credit;
  int[] prices;
  
  public TestCase(Scanner in) {
    credit = in.nextInt();
    prices = new int[in.nextInt()];

    for (int i = 0; i < prices.length; i++) {
      prices[i] = in.nextInt();
    }
  }
  
  public String solve(){
    Map<Integer, Integer> prices = new HashMap<>(this.prices.length);

    for (int i = 1; i <= this.prices.length; i++) {
      int ithPrice = this.prices[i-1];
      Integer index = prices.get(Integer.valueOf(credit - ithPrice));

      if (index != null) {
        return index + " " + Integer.toString(i);
      }
      prices.put(Integer.valueOf(ithPrice), Integer.valueOf(i));
    }
    throw new RuntimeException("input is wrong.");
  }
}