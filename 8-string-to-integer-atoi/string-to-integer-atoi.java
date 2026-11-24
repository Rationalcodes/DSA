class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // Step 1: Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Handle the sign
        int sign = 1;

        if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < n && s.charAt(i) == '+') {
            i++;
        }

        // Step 3: Set the appropriate negative limit
        int limit = (sign == -1)
                ? Integer.MIN_VALUE
                : -Integer.MAX_VALUE;

        int multMin = limit / 10;
        int result = 0;

        // Step 4: Read and convert digits
        while (i < n) {

            char c = s.charAt(i);

            // Stop at the first non-digit character
            if (c < '0' || c > '9') {
                break;
            }

            int digit = c - '0';

            // Step 5: Check overflow before multiplying
            if (result < multMin) {
                return sign == -1
                        ? Integer.MIN_VALUE
                        : Integer.MAX_VALUE;
            }

            result = result * 10;

            // Step 6: Check overflow before subtracting
            if (result < limit + digit) {
                return sign == -1
                        ? Integer.MIN_VALUE
                        : Integer.MAX_VALUE;
            }

            result = result - digit;

            i++;
        }

        // Step 7: Return the correctly signed result
        return sign == -1 ? result : -result;
    }
}