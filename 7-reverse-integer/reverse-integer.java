

class Solution {

    public int reverse(int x) {

        int reversed = 0;

        while (x != 0) {

            // Extract last digit
            int digit = x % 10;

            // Check overflow
            if (reversed > Integer.MAX_VALUE / 10 ||
               (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            // Check underflow
            if (reversed < Integer.MIN_VALUE / 10 ||
               (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            // Build reversed number
            reversed = reversed * 10 + digit;

            // Remove last digit
            x = x / 10;
        }

        return reversed;
    }
}