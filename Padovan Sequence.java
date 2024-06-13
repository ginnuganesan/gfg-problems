/* PROBLEM DESCRIPTION

Given a number n, find the nth number in the Padovan Sequence.

A Padovan Sequence is a sequence which is represented by the following recurrence relation
P(n) = P(n-2) + P(n-3)
P(0) = P(1) = P(2) = 1

Note: Since the output may be too large, compute the answer modulo 10^9+7.

Examples :

Input: n = 3
Output: 2
Explanation: We already know, P1 + P0 = P3 and P1 = 1 and P0 = 1
Input: n = 4
Output: 2
Explanation: We already know, P4  = P2 + P1 and P2 = 1 and P1 = 1
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <= 106

*/

//Solution

class Solution
{
  public int padovanSequence(int n)
    {
        //code here.
        if(n <= 2) {
            return 1;
        }
        int[] p = new int[n+1];
        int mod = 1000000007;
        p[0] = p[1] = p[2] = 1;
        int ans = 0;
        for(int i = 3; i <= n; i++) {
            p[i] = (p[i-2] + p[i-3]) % mod;
        }
        return p[n];
    }
    
}
