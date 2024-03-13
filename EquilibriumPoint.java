/* PROBLEM DESCRIPTION

Given an array A of n non negative numbers. The task is to find the first equilibrium point in an array. Equilibrium point in an array is an index (or position) such that the sum of all elements before that index is same as sum of elements after it.

Note: Return equilibrium point in 1-based indexing. Return -1 if no such point exists. 

Example 1:

Input: 
n = 5 
A[] = {1,3,5,2,2} 
Output: 
3 
Explanation:  
equilibrium point is at position 3 as sum of elements before it (1+3) = sum of elements after it (2+2). 
Example 2:

Input:
n = 1
A[] = {1}
Output: 
1
Explanation:
Since there's only element hence its only the equilibrium point.
Your Task:
The task is to complete the function equilibriumPoint() which takes the array and n as input parameters and returns the point of equilibrium. 

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <= 105
0 <= A[i] <= 109

*/

//Solution

class Solution {

    
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {

        // Your code here
        if(n == 1)
            return n;
        int a = 0, b = n-1;
        long rightSum = arr[a], leftSum = arr[b];
        while (a <= b) {
            if(rightSum == leftSum) {
                if(a+1 == b-1)
                    return a+2;
            } else if (rightSum < leftSum) {
                ++a;
                rightSum += arr[a];
            } else {
                --b;
                leftSum += arr[b];
            }
        }
        return -1;
    }
}
