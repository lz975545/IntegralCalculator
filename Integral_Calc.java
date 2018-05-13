import java.util.Scanner;

public class Integral_Calc {

    private static double f(double x) {
        return Math.exp(x);
    }

    // Integrate f from a to b using the trapezoidal rule
    private static double trapIntegrate(double a, double b, int n) {
        double deltaX = (b - a) / n;
        double sum = 0.5 * (f(a) + f(b));
        for (int i = 1; i < n; i++) {
            double x = a + deltaX * i;
            sum = sum + f(x);
        }
        return sum * deltaX;
    }

    // Integrate f from a to b using the left point rectangle rule
    private static double leftIntegrate(double a, double b, int n) {
        double deltaX = (b - a) / n;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += f(a + i * deltaX);
        }
        return sum * deltaX;
    }

    // Integrate f from a to b using the right point rectangle rule
    private static double rightIntegrate(double a, double b, int n) {
        double deltaX = (b - a) / n;
        double sum = 0;
        for (int i = 1; i < n; i++) {
            sum += f(a + i * deltaX);
        }
        return sum * deltaX;
    }

    // Integrate f from a to b using the mid point rectangle rule
    private static double midIntegrate(double a, double b, int n) {
        double deltaX = (b - a) / n;
        double sum = 0;
        for (int i = 0; i < n; i++)
            sum += f(a + (i + 0.5) * deltaX);
        return sum * deltaX;
    }

    // Integrate f from a to b using Simpson's rule
    private static double simpIntegrate(double a, double b, int n) {
        double deltaX = (b - a) / (n - 1);
        // 1/3 terms
        double sum = 1.0 / 3.0 * (f(a) + f(b));

        // 4/3 terms
        for (int i = 1; i < n - 1; i += 2) {
            double x = a + deltaX * i;
            sum += 4.0 / 3.0 * f(x);
        }

        // 2/3 terms
        for (int i = 2; i < n - 1; i += 2) {
            double x = a + deltaX * i;
            sum += 2.0 / 3.0 * f(x);
        }
        return sum * deltaX;
    }

    // Menu for user to choose different types of integration
    private static void showMenu() {
        System.out.println(" MENU ");
        System.out.println("   1. Left hand Riemann sum ");
        System.out.println("   2. Right hand Riemann sum ");
        System.out.println("   3. Midpoint Riemann sum ");
        System.out.println("   4. Trapezoidal rule ");
        System.out.println("   5. Simpson's rule ");
        System.out.println("   6. Quit the program ");
        System.out.print("Select method of integration: ");
    }

    private static void quitProgram() {
        System.out.println("Goodbye!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Integrating the function f(x) = e^x\n");
        System.out.print("Input lower bound: ");
        double a = sc.nextDouble();
        System.out.print("Input upper bound: ");
        double b = sc.nextDouble();
        System.out.print("Input number of rectangles: ");
        int n = sc.nextInt();

        if (true) {
            showMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Area = " + leftIntegrate(a, b, n));
                    break;
                case 2:
                    System.out.println("Area = " + rightIntegrate(a, b, n));
                    break;
                case 3:
                    System.out.println("Area = " + midIntegrate(a, b, n));
                    break;
                case 4:
                    System.out.println("Area = " + trapIntegrate(a, b, n));
                    break;
                case 5:
                    System.out.println("Area = " + simpIntegrate(a, b, n));
                    break;
                case 6:
                    quitProgram();
                    break;
            }
        }
    }
}