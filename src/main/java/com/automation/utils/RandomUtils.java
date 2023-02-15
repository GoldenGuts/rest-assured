package com.automation.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RandomUtils {

  public static int getId() {
    return 52342;
  }

  public static String getFirstname() {
    return "John";
  }

  public static String getLastname() {
    return "Doe";
  }
}
