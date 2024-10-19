/* PROBLEM DESCRIPTION

A string str is given to represent a positive number. The task is to round str to the nearest multiple of 10.  If you have two multiples equally apart from str, choose the smallest element among them.

Examples:

Input: str = 29 
Output: 30
Explanation: Close multiples are 20 and 30, and 30 is the nearest to 29. 
Input: str = 15
Output: 10
Explanation: 10 and 20 are equally distant multiples from 20. The smallest of the two is 10.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1 <= str.size()<= 105

*/

//Solution

class Solution {

    String roundToNearest(String str) {
        // Complete the function
        int length = str.length();
        int lastDigit = str.charAt(length-1) - '0';
        if(lastDigit == 0) {
            return str;
        }
        if(length == 1) {
            if(Integer.parseInt(str) <= 5) {
                return "0";
            }
            return "10";
        }
        
        if(lastDigit <= 5) {
            return str.substring(0, length-1) + "0";
        }
        int carry = 1;
        StringBuilder out = new StringBuilder();
        for(int i = length - 1; i >= 0; i--) {
            if(i == length - 1) {
                out.append('0');
            } else {
                int digit = (str.charAt(i) - '0') + carry;
                if(digit == 10) {
                    out.append('0');
                } else {
                    out.append(digit);
                    carry = 0;
                }
            }
        }
        if(carry == 1) {
            out.append(carry);
        }
        return out.reverse().toString();
    }
}
