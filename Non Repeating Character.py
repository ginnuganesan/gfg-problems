''' PROBLEM DESCRIPTION

Given a string S consisting of lowercase Latin Letters. Return the first non-repeating character in S. If there is no non-repeating character, return '$'.

Example 1:

Input:
S = hello
Output: h
Explanation: In the given string, the
first character which is non-repeating
is h, as it appears first and there is
no other 'h' in the string.
Example 2:

Input:
S = zxvczbtxyzvy
Output: c
Explanation: In the given string, 'c' is
the character which is non-repeating. 
Your Task:
You only need to complete the function nonrepeatingCharacter() that takes string S as a parameter and returns the character. If there is no non-repeating character then return '$' .

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Number of distinct characters).
Note: N = |S|

Constraints:
1 <= N <= 105

'''

''' TLE Java Solution

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
        for(int i = 0; i < S.length(); i++) {
            String sub = S.replaceFirst(String.valueOf(S.charAt(i)), "");
            int i1 = sub.indexOf(S.charAt(i));
            if(i1 == -1)
                return S.charAt(i);
        }
        return '$';
    }
}

'''

#Python Solution

class Solution:
    
    #Function to find the first non-repeating character in a string.
    def nonRepeatingChar(self,s):
        #code here
        map = [0] * 26
        for char in s:
            map[ord(char) - ord("a")] += 1
        
        for i in range(len(s)):
            if map[ord(s[i]) - ord("a")] == 1:
                return s[i]
        
        return "$"
