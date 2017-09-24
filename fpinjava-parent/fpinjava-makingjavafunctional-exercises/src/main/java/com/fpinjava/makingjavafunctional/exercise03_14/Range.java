package com.fpinjava.makingjavafunctional.exercise03_14;

import static com.fpinjava.makingjavafunctional.exercise03_13.CollectionUtilities.*;

import java.util.List;

public class Range {

  public static List<Integer> range(Integer start, Integer end) {
    if (start >= end) {
      return list();
    }

    return prepend(start, range(start + 1, end));
  }
}
