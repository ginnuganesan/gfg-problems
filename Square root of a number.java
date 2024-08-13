/* PROBLEM DESCRIPTION

Given an integer n, find the square root of n. If n is not a perfect square, then return the floor value.

Floor value of any number is the greatest Integer which is less than or equal to that number

Examples:

Input: n = 5
Output: 2
Explanation: Since, 5 is not a perfect square, floor of square_root of 5 is 2.
Input: n = 4
Output: 2
Explanation: Since, 4 is a perfect square, so its square root is 2.
Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ n ≤ 107

*/

//Solution

class Solution {
    long floorSqrt(long n) {
        // Your code here
        if(n == 0 || n == 1) {
            return n;
        }
        long start = 1, end = n/2, ans = 0;
        while(start <= end) {
            long mid = (start + end) / 2;
            long sqr = mid * mid;
            if(sqr == n) {
                return mid;
            }
            
            if(sqr <= n) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
