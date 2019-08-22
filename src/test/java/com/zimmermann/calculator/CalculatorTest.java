package com.zimmermann.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Hier testen wir alle Mehtoden
 */
public class CalculatorTest {

  private Calculator calculator = new Calculator();

  /**
   * Hier testen wir die Sum-Methode
   */
  @Test
  public void testSum() {
    assertEquals(5, calculator.sum(2, 3));
  }
}
