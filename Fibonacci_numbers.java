public class Fibonacci_numbers {
    // if any errors while running, running bash in the terminal resolves computer
    // not being able to find the program

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Fibonacci <n>");
            System.out.println("Where <n> is the index of the Fibonacci number to calculate.");
            return;
        }

        try {
            int n = Integer.parseInt(args[0]);
            if (n < 0) {
                System.out.println("Please enter a non-negative integer.");
                return;
            }

            long fibonacci = calculate_fibonacci_iterative(n);
            System.out.println("The " + n + "th Fibonacci number is: " + fibonacci);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }

    // Iterative function to calculate the nth Fibonacci number
    public static long calculate_fibonacci_iterative(int n) {
        if (n <= 1) {
            return n;
        }

        long a = 0, b = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
