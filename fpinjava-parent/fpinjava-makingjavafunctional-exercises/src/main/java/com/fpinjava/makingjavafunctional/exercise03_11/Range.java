package com.fpinjava.makingjavafunctional.exercise03_11;

import com.fpinjava.common.Function;

import java.util.List;

import static com.fpinjava.makingjavafunctional.exercise03_10.CollectionUtilities.*;


public class Range {
  public static Function<Integer, Integer> increment = x -> x + 1;

  public static List<Integer> range(int start, int end) {
    List<Integer> result = list();
    for (int i = start; i < end; i = increment.apply(i)) {
      result = append(result, i);
    }

    return result;
  }
}
