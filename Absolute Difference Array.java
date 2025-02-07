/* PROBLEM DESCRIPTION

You are given a string s of lowercase English letters.&nbsp;Your task is to find for each index i, 
the absolute difference between the frequency of vowels, and the frequency of consonants in the substring s[0...i]. 
Return an array of length n, where n is the length of string s, 
and the ith element is the absolute difference between the frequency of vowels, and the frequency of consonants in the substring s[0...i].

Examples:

Input: s = "geek"
Output: [1, 0, 1, 0]
Explanation: 
The substring s[0...0] = "g". The frequency of vowels is 0, and the frequency of consonants is 1. The absolute difference is 1.
The substring s[0...1] = "ge". The frequency of vowels is 1, and the frequency of consonants is 1. The absolute difference is 0.
The substring s[0...2] = "gee". The frequency of vowels is 2, and the frequency of consonants is 1. The absolute difference is 1.
The substring s[0...3] = "geek". The frequency of vowels is 2, and the frequency of consonants is 2. The absolute difference is 0.

Input: s = "abcde"
Output: [1, 0, 1, 2, 1]
Explanation:
The substring s[0...0] = "a". The frequency of vowels is 1, and the frequency of consonants is 0. The absolute difference is 1.
The substring s[0...1] = "ab". The frequency of vowels is 1, and the frequency of consonants is 1. The absolute difference is 0.
The substring s[0...2] = "abc". The frequency of vowels is 1, and the frequency of consonants is 2. The absolute difference is 1.
The substring s[0...3] = "abcd". The frequency of vowels is 1, and the frequency of consonants is 3. The absolute difference is 2.
The substring s[0...4] = "abcde". The frequency of vowels is 2, and the frequency of consonants is 3. The absolute difference is 1.

*/

//Solution

class Solution {
    public int[] absDifference(String s) {
        // code here
        int vowelCount = 0, consCount = 0, length = s.length();
        int[] out = new int[length];
        for (int i = 0; i < length; i++) {
            if (isVowel(s.charAt(i))) {
                vowelCount++;
            } else {
                consCount++;
            }
            out[i] = Math.abs(consCount - vowelCount);
        }
        return out;
    }
    
    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}
