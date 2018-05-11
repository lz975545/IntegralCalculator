package integral_calc;

import java.util.Scanner;

public class Integral_Calc {

	static double f(double x) {
		return Math.log(x) * Math.sqrt(x);
	}

	// Integrate f from a to b using the trapezoidal rule
	static double integrate(double a, double b, int n) {
		double delt = (b - a) / n;			//step size
		double sum = 0.5 * (f(a) + f(b));	// area
		for (int i = 1; i < n; i++) {
			double x = a + delt * i;
			sum = sum + f(x);
		}
		return sum * delt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Integrating the function f(x) = ln(x)*sqrt(x)\n");
		System.out.print("Input lower bound: ");
		double a = sc.nextDouble();
		System.out.print("Input upper bound: ");
		double b = sc.nextDouble();
		System.out.print("Input number of rectangles: ");
		int n = sc.nextInt();
		System.out.println(integrate(a, b, n));
	}

}
