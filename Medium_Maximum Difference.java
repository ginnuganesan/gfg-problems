/* PROBLEM DESCRIPTION

Given an integer array arr of integers, the task is to find the maximum absolute difference between the nearest left smaller element and the nearest right smaller element of every element in array arr. If for any component of the arr, the nearest smaller element doesn't exist then consider it as 0.

Examples :

Input: arr = [2, 1, 8]
Output: 1
Explanation: left smaller array ls = [0, 0, 1], right smaller array rs = [1, 0, 0]. Maximum Diff of abs(ls[i] - rs[i]) = 1
Input: arr = [2, 4, 8, 7, 7, 9, 3]
Output: 4
Explanation: left smaller array ls = [0, 2, 4, 4, 4, 7, 2], right smaller rs = [0, 3, 7, 3, 3, 3, 0]. Maximum Diff of abs(ls[i] - rs[i]) = abs(7 - 3) = 4
Expected Time Complexity: O(n)
Expected Space Complexity: O(n)

Constraints:
1 <= arr.size() <= 106
1<= arr[i] <=109

*/

//Solution

class Solution {
    public int findMaxDiff(int[] arr) {
        // code here
        int n = arr.length;
        int[] ls = new int[n];
        leftSmaller(arr, n, ls);
        int[] rs = new int[n];
        rightSmaller(arr, n, rs);
        
        int maxDiff = -1;
        for(int i = 0; i < n; i++) {
            //System.out.println("ls: " + ls[i] + ", rs: " + rs[i]);
            maxDiff = Math.max(maxDiff, Math.abs(ls[i] - rs[i]));
        }
        return maxDiff;
    }
    
    public void leftSmaller(int[] arr, int n, int[] out) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                out[i] = stack.peek();
            } else {
                out[i] = 0;
            }
            stack.push(arr[i]);
        }
    }
    
    public void rightSmaller(int[] arr, int n, int[] out) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                out[i] = stack.peek();
            } else {
                out[i] = 0;
            }
            stack.push(arr[i]);
        }
    }
}
