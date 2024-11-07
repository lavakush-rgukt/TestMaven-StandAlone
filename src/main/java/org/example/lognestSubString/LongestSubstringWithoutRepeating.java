package org.example.lognestSubString;



import java.util.HashSet;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character already exists in the set, remove characters from the left until it's removed
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set and update the max length if needed
            set.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(set);
        return maxLength;
    }

    public static void main(String[] args) {
        String input = "abcdb";
        int result = lengthOfLongestSubstring(input);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}

