/* PROBLEM DESCRIPTION

Given a binary tree and an integer target, check whether there is a root-to-leaf path with its sum as target.

Examples :

Input: tree = 1, target = 2
            /   \
          2     3
Output: false
Explanation: There is no root to leaf path with sum 2.
Input: tree = 1,  target = 4
            /   \
          2     3
Output: true
Explanation: The sum of path from leaf node 3 to root 1 is 4.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(height of tree)

Constraints:
1 ≤ number of nodes ≤ 104
1 ≤ target ≤ 106

*/

//Solution

/*
// A Binary Tree node
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    /*you are required to complete this function */
    boolean hasPathSum(Node root, int target) {
        // Your code here
        if(root == null) {
            return false;
        }
        
        boolean res = false;
        int subSum = target - root.data;
        
        if(subSum == 0 && root.left == null && root.right == null) {
            return (res = true);
        }
        
        if(root.left != null) {
            res = res || hasPathSum(root.left, subSum);
        }
        
        if(root.right != null) {
            res = res || hasPathSum(root.right, subSum);
        }
        
        return res;
    }
}
