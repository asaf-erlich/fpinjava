package com.fpinjava.recursion.exercise04_09;

import static com.fpinjava.common.TailCall.ret;
import static com.fpinjava.common.TailCall.sus;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import com.fpinjava.common.CollectionUtilities;
import com.fpinjava.common.TailCall;


public class Memoization {
  public static String fibo(int number) {
    if (number <= 0) return "0";
    if (number == 1) return "0, 1";

    return makeString(fibo_(number, CollectionUtilities.list(BigInteger.ZERO, BigInteger.ONE)).eval(), ", ");
  }

  public static TailCall<List<BigInteger>> fibo_(final int number, final List<BigInteger> accumulator) {

    final BigInteger fibNMinus1 = accumulator.get(accumulator.size() - 1);
    final BigInteger fibMinus2 = accumulator.get(accumulator.size() - 2);
    final BigInteger fibonacci = fibNMinus1.add(fibMinus2);

    final List<BigInteger> newAccumulator = CollectionUtilities.append(accumulator, fibonacci);
    if (accumulator.size() == number) {
      return ret(newAccumulator);
    } else {
      return sus(() -> fibo_(number, newAccumulator));
    }
  }

  public static <T> String makeString(List<T> list, String separator) {
    return list.stream().map(i -> i.toString())
        .collect(Collectors.joining(separator));
  }
}
