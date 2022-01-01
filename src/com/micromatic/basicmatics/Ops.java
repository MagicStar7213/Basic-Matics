package com.micromatic.basicmatics;

/**Sets the ops methods*/
public class Ops {
	/**
	 * @param a Dividend
	 * @param b Dividing
	 * @return division of both parameters @param a and @param b
	 */
	public static double divide(double a, double b) {
		return a / b;
	}

	/**
	 * @param a Dividend
	 * @param b Dividing
	 * @return rest of the division of both parameters @param a and @param b
	 */
	public static double divideRest(double a, double b) {
		return a % b;
	}

	/**
	 * @param a Multiplicand
	 * @param b Multiplying
	 * @return multiplication of both parameters @param a and @param b
	 */
	public static double mtpl(double a, double b) {
		return a * b;
	}

	/**
	 * @param a Minuend
	 * @param b Subtracting
	 * @return subtraction of both parameters @param a and @param b
	 */
	public static double rest(double a, double b) {
		return a - b;
	}

	/**
	 * @param a Adding
	 * @param b Adding
	 * @return addition of both parameters @param a and @param b
	 */
	public static double sume(double a, double b) {
		return a + b;
	}
}