package CodeWars;

/*
A Narcissistic Number (or Armstrong Number) is a positive number which is the sum of its own digits, each raised
to the power of the number of digits in a given base. In this Kata, we will restrict ourselves to decimal (base 10).

For example, take 153 (3 digits), which is narcissistic:

    1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153

1652 (4 digits), which isn't:
    1^4 + 6^4 + 5^4 + 2^4 = 1 + 1296 + 625 + 16 = 1938

The Challenge:

Your code must return true or false (not 'true' and 'false') depending upon whether the given number
is a Narcissistic number.

Error checking for text strings or other invalid inputs is not required,
only valid positive non-zero integers will be passed into the function.
 */

import java.util.Arrays;

/*

We know that a number is narcissistic if its the sum of its digits, each elevated to the power of the total number of
digits.

So a way to know if a number is narcissistic is to calculate the number using the narcissistic method (NM) and see
if that equals the input.

So to calculate the number using NM we need to get each digit of the number individually, and power that to the number
of digits. So two blockers:

1) How do we get each digit?
2) How do we get the TOTAL digits?
 */
public class NarcissisticNumber {
    public static boolean isNarcissistic(int number) {
        int totalSum = 0;
        String strNum = String.valueOf(number);
        int totalDigits = strNum.length();

        for (int i = 0; i < strNum.length(); i++) {
            char charDigit = strNum.charAt(i);
            int digit = Character.getNumericValue(charDigit);
            totalSum += Math.pow(digit, totalDigits);
        }

        return totalSum == number;
    }

    // Another solution using streams.
    public static boolean isNarcissisticTwo(int number) {
        int totalDigits = String.valueOf(number).length();
        return number == Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .mapToDouble(m -> Math.pow(m, totalDigits))
                .sum();
    }
}


