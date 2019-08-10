package com.zimmermann.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

  private Calculator calculator = new Calculator();

  @Test
  public void testSum() {
    assertEquals(5, calculator.sum(2, 3));
  }
}
