/* PROBLEM DESCRIPTION

Given a linked list with string data, check whether the combined string formed is palindrome. If the combined string is palindrome then return true otherwise return false.

Example:

Input:

Output : true
Explanation: As string "abcddcba" is palindrome the function should return true.
Input:

Output : false
Explanation: As string "abcdba" is not palindrome the function should return false.
Expected Time Complexity:  O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= Node.data.length<= 103
1<=list.length<=103

*/

//Solution

class Solution {
    public boolean compute(Node root) {
        Node temp = root;
        StringBuilder str = new StringBuilder();
        while(temp != null) {
            str.append(temp.data);
            temp = temp.next;
        }
        if(str.toString().equals(str.reverse().toString())) {
            return true;
        }
        return false;
    }
}
