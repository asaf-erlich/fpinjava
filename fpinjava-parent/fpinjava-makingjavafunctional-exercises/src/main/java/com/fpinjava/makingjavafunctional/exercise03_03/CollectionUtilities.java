package com.fpinjava.makingjavafunctional.exercise03_03;

import java.util.*;
import java.util.stream.*;


public class CollectionUtilities {

  public static <T> List<T > list() {
    return Collections.unmodifiableList(new ArrayList<>());
  }

  public static <T> List<T > list(T t) {
    return Collections.singletonList(t);
  }
  public static <T> List<T > list(List<T> ts) {
    return Collections.unmodifiableList(new ArrayList<>(ts));
  }

  @SafeVarargs
  public static <T> List<T > list(T... t) {
    return Collections.unmodifiableList(Arrays.stream(t).collect(Collectors.toList()));
  }
}
