/* PROBLEM DESCRIPTION

Given an encoded string s, the task is to decode it. The encoding rule is :

k[encodedString], where the encodedString inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
Note: The test cases are generated so that the length of the output string will never exceed 105 .

Examples:

Input: s = "1[b]"
Output: "b"
Explanation: "b" is present only one time.
Input: s = "3[b2[ca]]"
Output: "bcacabcacabcaca"
Explanation:
1. Inner substring “2[ca]” breakdown into “caca”.
2. Now, new string becomes “3[bcaca]”
3. Similarly “3[bcaca]” becomes “bcacabcacabcaca ” which is final result.
Constraints:
1 ≤ |s| ≤ 105 

*/

//Solution

class Solution {
    static String decodeString(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                st.push(s.charAt(i));
            } else {
                StringBuilder str = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '[') {
                    str.append(st.pop());
                }
                str.reverse();
                st.pop();
                StringBuilder num = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    num.append(st.pop());
                }
                num.reverse();
                int multiplier = Integer.parseInt(num.toString());
                StringBuilder rep = new StringBuilder();
                for (int j = 0; j < multiplier; j++) {
                    rep.append(str);
                }
                for(char ch: rep.toString().toCharArray()) {
                    st.push(ch);
                }
            }
        }
        
        StringBuilder out = new StringBuilder();
        while (!st.isEmpty()) {
            out.append(st.pop());
        }
        
        out.reverse();
        return out.toString();
    }
}
