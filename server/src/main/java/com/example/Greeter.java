package com.example;

/**
 * Produces greeting messages.
 */
public class Greeter {

  /**
   * Builds a greeting for the given name.
   *
   * @param someone the name to greet
   * @return the greeting message
   */
  public String greet(String someone) {
    return String.format("Hello, %s!", someone);
  }
}
