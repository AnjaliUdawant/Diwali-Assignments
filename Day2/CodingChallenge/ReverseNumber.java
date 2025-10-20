import java.util.Scanner;

public class ReverseNumber {

    // Function to reverse digits
    public static int reverseDigits(int n) {
        boolean isNegative = n < 0;
        n = Math.abs(n); // Make number positive for processing

        int reversed = 0;
        while (n > 0) {
            int digit = n % 10;           // Get last digit
            reversed = reversed * 10 + digit; // Add digit to reversed number
            n = n / 10;                   // Remove last digit
        }

        return isNegative ? -reversed : reversed; // Add negative sign if needed
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();

        int result = reverseDigits(num);
        System.out.println("Reversed number: " + result);
    }
}
