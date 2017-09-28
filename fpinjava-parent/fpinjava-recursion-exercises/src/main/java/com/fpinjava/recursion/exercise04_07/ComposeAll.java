  package com.fpinjava.recursion.exercise04_07;

import java.util.List;

import com.fpinjava.common.Function;

import static com.fpinjava.recursion.exercise04_03.FoldLeft.foldLeft;
import static com.fpinjava.recursion.exercise04_05.FoldRight.foldRight;

  public class ComposeAll {

  public static <T> Function<T, T> composeAll(List<Function<T, T>> list) {
    return identity -> {
      T result = identity;

      for (Function<T, T> f : list) {
        result = f.apply(result);
      }

      return result;
    };
  }
  public static <T> Function<T, T> composeAllViaFoldLeft(List<Function<T, T>> list) {
    return identity -> foldLeft(list, identity, f1 -> f2 -> f2.apply(f1));
  }

  public static <T> Function<T, T> composeAllViaFoldRight(List<Function<T, T>> list) {
    return identity -> foldRight(list, identity, f -> f::apply);
  }
}
