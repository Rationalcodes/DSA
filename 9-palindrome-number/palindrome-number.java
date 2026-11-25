class Solution {
    public boolean isPalindrome(int x) {

        // Step 1: Negative numbers are not palindromes
        // Numbers ending in 0 are not palindromes (except 0)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;

        // Step 2: Reverse only half of the number
        while (x > reversed) {

            int digit = x % 10;

            reversed = reversed * 10 + digit;

            x = x / 10;
        }

        // Step 3: Compare both halves
        return x == reversed || x == reversed / 10;
    }
}