package com.fpinjava.recursion.exercise04_05;

import java.util.List;

import com.fpinjava.common.Function;
import com.fpinjava.common.TailCall;

import static com.fpinjava.common.CollectionUtilities.*;

public class FoldRight {

  public static <T, U> U foldRight(List<T> ts, U identity, Function<T, Function<U, U>> f) {
    return foldRightHelper(reverse(ts), identity, f).eval();
  }

  public static <T, U> TailCall<U> foldRightHelper(List<T> ts, U identity, Function<T, Function<U, U>> f) {
    if (ts.isEmpty()) return TailCall.ret(identity);

    return TailCall.sus(() -> foldRightHelper(tail(ts), f.apply(head(ts)).apply(identity), f));
  }
}
