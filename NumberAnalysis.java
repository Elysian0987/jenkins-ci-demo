// NumberAnalysis.java
import java.math.BigInteger;
import java.io.FileWriter;
import java.io.IOException;

public class NumberAnalysis {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Usage: java NumberAnalysis <num> [outputFile]");
            System.exit(2);
        }

        int num;
        try {
            num = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number: " + args[0]);
            System.exit(2);
            return;
        }

        String outFile = args.length >= 2 ? args[1] : null;
        StringBuilder sb = new StringBuilder();
        sb.append("Input Number: ").append(num).append("\n");

        if (num < 0) {
            sb.append("Factorial: Not defined for negative numbers\n");
        } else {
            BigInteger factorial = BigInteger.ONE;
            for (int i = 2; i <= num; i++) factorial = factorial.multiply(BigInteger.valueOf(i));
            sb.append("Factorial = ").append(factorial.toString()).append("\n");

            // Sum of digits of factorial (interesting extra metric)
            int sumDigits = 0;
            for (char c : factorial.toString().toCharArray()) sumDigits += (c - '0');
            sb.append("SumOfDigitsOfFactorial = ").append(sumDigits).append("\n");
        }

        // Prime check (fast/simple)
        boolean isPrime = isPrime(num);
        sb.append(isPrime ? (num + " is a Prime number\n") : (num + " is NOT a Prime number\n"));

        // Extra metric: number of digits in factorial (shows big-int handling)
        if (num >= 0) {
            BigInteger factLen = BigInteger.ONE;
            for (int i = 2; i <= num; i++) factLen = factLen.multiply(BigInteger.valueOf(i));
            sb.append("DigitsInFactorial = ").append(factLen.toString().length()).append("\n");
        }

        String output = sb.toString();
        System.out.println(output);

        if (outFile != null) {
            try (FileWriter fw = new FileWriter(outFile)) {
                fw.write(output);
            }
            System.out.println("Results saved to " + outFile);
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0) return false;
        int r = (int)Math.sqrt(n);
        for (int i = 3; i <= r; i += 2) if (n % i == 0) return false;
        return true;
    }
}

//Adding a comment to test 
