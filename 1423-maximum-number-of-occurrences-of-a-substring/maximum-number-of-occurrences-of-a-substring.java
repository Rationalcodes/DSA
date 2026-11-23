import java.util.HashMap;

class Solution {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        // Store substring frequencies
        HashMap<String, Integer> map = new HashMap<>();

        // Character frequency array
        int[] freq = new int[26];

        int unique = 0;
        int maxCount = 0;

        // Sliding window
        for (int i = 0; i < s.length(); i++) {

            // Add incoming character
            int index = s.charAt(i) - 'a';

            if (freq[index] == 0) {
                unique++;
            }

            freq[index]++;

            // Remove outgoing character when window exceeds minSize
            if (i >= minSize) {

                int removeIndex = s.charAt(i - minSize) - 'a';

                freq[removeIndex]--;

                if (freq[removeIndex] == 0) {
                    unique--;
                }
            }

            // Process only complete windows
            if (i >= minSize - 1) {

                // Check unique character condition
                if (unique <= maxLetters) {

                    String sub = s.substring(i - minSize + 1, i + 1);

                    int count = map.getOrDefault(sub, 0) + 1;

                    map.put(sub, count);

                    maxCount = Math.max(maxCount, count);
                }
            }
        }

        return maxCount;
    }
}