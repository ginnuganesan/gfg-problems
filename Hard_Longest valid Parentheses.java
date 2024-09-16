/* PROBLEM DESCRIPTION

Given a string str consisting of opening and closing parenthesis '(' and ')'. Find length of the longest valid parenthesis substring.

A parenthesis string is valid if:

For every opening parenthesis, there is a closing parenthesis.
Opening parenthesis must be closed in the correct order.
Examples :

Input: str = ((()
Output: 2
Explaination: The longest valid parenthesis substring is "()".
Input: str = )()())
Output: 4
Explaination: The longest valid parenthesis substring is "()()".
Expected Time Complexity: O(|str|)
Expected Auxiliary Space: O(|str|)

Constraints:
1 ≤ |str| ≤ 105  

*/

//Solution

class Solution{
    static int maxLength(String S){
        // code here
        int left = 0, right = 0, maxLength = 0;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if(left == right) {
                maxLength = Math.max(maxLength, left + right);
            } else if(right > left) {
                right = left = 0;
            }
        }
        right = left = 0;
        for(int i = S.length() - 1; i >= 0; i--) {
            if(S.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if(left == right) {
                maxLength = Math.max(maxLength, left + right);
            } else if(left > right) {
                right = left = 0;
            }
        }
        return maxLength;
    }
}
