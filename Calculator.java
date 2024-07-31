public class Calculator {

    // Method to calculate factorial with parameter validation
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is only defined for non-negative numbers.");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Method to calculate binomial coefficient with parameter validation
    public static int binomialCoefficient(int n, int k) {
        if (n < 0 || k < 0 || k > n) {
            throw new IllegalArgumentException("Parameters must be non-negative and subset size must not exceed the set size.");
        }
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static void main(String[] args) {
        try {
            System.out.println("Factorial of 5: " + factorial(5)); // Expected: 120
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Binomial coefficient C(5, 3): " + binomialCoefficient(5, 3)); // Expected: 10
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            factorial(-1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected: Factorial is only defined for non-negative numbers.
        }

        try {
            binomialCoefficient(5, -1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected: Parameters must be non-negative and subset size must not exceed the set size.
        }

        try {
            binomialCoefficient(5, 6);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected: Parameters must be non-negative and subset size must not exceed the set size.
        }
    }
}
