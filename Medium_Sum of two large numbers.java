/* PROBLEM DESCRIPTION

Given two strings denoting non-negative numbers X and Y. Calculate the sum of X and Y.


Example 1:

Input:
X = "25", Y = "23"
Output:
48
Explanation:
The sum of 25 and 23 is 48.
Example 2:

Input:
X = "2500", Y = "23"
Output:
2523
Explanation:
The sum of 2500 and 23 is 2523.

Your Task:
Your task is to complete the function findSum() which takes two strings as inputs and returns the string without leading zeros. You do not need to take any input or print anything.


Expected Time Complexity: O(|X| + |Y|)
Expected Auxiliary Space: O(1)


Constraints:
1 <= |X|, |Y| <= 105

*/

//Solution

class Solution {
    String findSum(String X, String Y) {
        // code here
        int carry = 0, i = X.length() - 1, j = Y.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 && j >= 0) {
            int sum = (X.charAt(i) - '0') + (Y.charAt(j) - '0') + carry;
            if(sum > 9) {
                carry = 1;
                sb.append(sum % 10);
            } else {
                carry = 0;
                sb.append(sum);
            }
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = (X.charAt(i) - '0') + carry;
            if(sum > 9) {
                carry = 1;
                sb.append(sum % 10);
            } else {
                carry = 0;
                sb.append(sum);
            }
            i--;
        }
        while (j >= 0) {
            int sum = (Y.charAt(j) - '0') + carry;
            if(sum > 9) {
                carry = 1;
                sb.append(sum % 10);
            } else {
                carry = 0;
                sb.append(sum);
            }
            j--;
        }
        
        if(carry > 0) {
            sb.append(carry);
        }
        
        sb.reverse();
        int index;
        for(index = 0; index < sb.length(); index++) {
            if(sb.charAt(index) != '0') {
                break;
            }
        }
        return index == sb.length() ? "0" : sb.toString().substring(index);
    }
}
