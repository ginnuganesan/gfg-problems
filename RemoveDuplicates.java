/* PROBLEM DESCRIPTION

Given a string without spaces, the task is to remove duplicates from it.

Note: The original order of characters must be kept the same. 

Example 1:

Input: S = "zvvo"
Output: "zvo"
Explanation: Only keep the first
occurrence
Example 2:

Input: S = "gfg"
Output: gf
Explanation: Only keep the first
occurrence
Your task:
Your task is to complete the function removeDups() which takes a single string as input and returns the string. You need not take any input or print anything.
 

Expected Time Complexity: O(|s|)
Expected Auxiliary Space: O(constant)

Constraints:
1 <= |S| <= 105

*/

//Solution

class Solution {
    String removeDups(String S) {
        // code here
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            if(!out.toString().contains(String.valueOf(S.charAt(i)))) {
                out.append(S.charAt(i));
            }
        }
        return out.toString();
        
    }
}
