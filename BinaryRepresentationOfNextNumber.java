/* PROBLEM DESCRIPTION

Given a binary representation in the form of a string(s) of a number n, the task is to find a binary representation of n+1.

Note: Output binary string should not contain leading zeros.

Example 1:

Input: s = "10"
Output: 11
Explanation: "10" is the binary representation of 2 and binary representation of 3 is "11"
Example 2:

Input: s = "111"
Output: 1000
Explanation: "111" is the binary representation of 7 and binary representation of 8 is "1000"
Your Task:  
You don't need to read input or print anything. Complete the function binaryNextNumber()which takes s as input parameter and returns the string.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n) to store resultant string  

Constraints:
1 <= n <= 105

*/

//Solution

class Solution {
    String binaryNextNumber(String s) {
        // code here.
        int carry = 0;
        StringBuilder out = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            int sum = 0, bit = (s.charAt(i) - '0');
            if(i == s.length() - 1) {
                sum = (s.charAt(i) - '0') + 1;
            } else {
                sum = (s.charAt(i) - '0') + carry;
            }
            carry = sum / 2;
            out.append(sum % 2);
        }
        if(carry > 0) {
            out.append(carry);
        }
        return out.reverse().toString().replaceFirst("0*", "");
    }
}
