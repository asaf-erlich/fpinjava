package com.fpinjava.makingjavafunctional.exercise03_01;


import java.util.regex.Pattern;

import com.fpinjava.common.Function;
import com.fpinjava.makingjavafunctional.exercise03_01.Effect;
import com.fpinjava.makingjavafunctional.exercise03_01.Result;

public class EmailValidation {

  static Pattern emailPattern =
      Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

  static Function<String, Result<String>> emailChecker = emailAddress -> {
    if (emailAddress == null) {
      return Result.failure("emailAddress must not be null");
    }

    if (emailAddress.trim().equals("")) {
      return Result.failure("emailAddress must not be empty");
    }

    if (!emailPattern.matcher(emailAddress).matches()) {
      return Result.failure("emailAddress " + emailAddress + " is invalid and doesn't match pattern " + emailPattern);
    }

    return Result.success(emailAddress);
  };

  public static void main(String... args) {
    emailChecker.apply("this.is@my.email").bind(success, failure);
    emailChecker.apply(null).bind(success, failure);
    emailChecker.apply("").bind(success, failure);
    emailChecker.apply("john.doe@acme.com").bind(success, failure);
  }

  static Effect<String> success = emailAddress -> System.out.println("Mail sent to " + emailAddress);
  
  static Effect<String> failure = errorMessage -> System.err.println("Error message logged: " + errorMessage);
}