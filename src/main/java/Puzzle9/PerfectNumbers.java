package Puzzle9;

// A number is considered perfect if its digits sum up to exactly 10.
// Given a positive integer n, return the n-th perfect number.
// For example, given 1, you should return 19. Given 2, you should return 28.


public class PerfectNumbers {

    // Brute Force approach where we check each number to see if it is perfect.
    // Couldn't think of better approach in time given yesterday.
    // High enough values of n will cause integer overflow and cause non-perfect numbers to be returned.
    // Solve by using long and/or returning error if number goes above Integer.MAX_VALUE.
    public static int perfectNumber(int n) {
        int count = 0;
        int number = 1;
        while (count < n) {
            if (isPerfectNumber(number)) {
                count++;
            }
            number++;
        }
        return number - 1;
    }

    public static boolean isPerfectNumber(int n) {
        int sumOfDigits = 0;
        while (n != 0 && sumOfDigits < 10) {
            sumOfDigits += n % 10;
            n /= 10;
        }
        return n == 0 && sumOfDigits == 10;
    }
}
