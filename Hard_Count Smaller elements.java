/* PROBLEM DESCRIPTION

Given an array arr containing non-negative integers. Count and return an array ans where ans[i] denotes the number of smaller elements on right side of arr[i].

Examples:

Input: arr[] = [12, 1, 2, 3, 0, 11, 4]
Output: [6, 1, 1, 1, 0, 1, 0]
Explanation: There are 6 smaller elements right after 12. There is 1 smaller element right after 1. And so on.
Input: arr[] = [1, 2, 3, 4, 5]
Output: [0, 0, 0, 0, 0]
Explanation: There are 0 smaller elements right after 1. There are 0 smaller elements right after 2. And so on.
Expected Time Complexity: O(n*logn)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i]  ≤ 108

*/

//Solution - Brute Force

class Solution {
    int[] constructLowerArray(int[] arr) {
        // code here
        int n = arr.length;
        int[] out = new int[n];
        for(int i = 0; i < n; i++) {
            if(i >= n-2) {
                if(i == n-2 && arr[n-1] < arr[n-2]) {
                    out[i] = 1;
                } else {
                    out[i] = 0;
                }
                continue;
            }
            int l = i+1, r = n-1, count = 0;
            while(l <= r) {
                if(l == r) {
                    if(arr[l] < arr[i]) {
                        count++;
                    }
                } else {
                    if(arr[l] < arr[i]) {
                        count++;
                    }
                    if(arr[r] < arr[i]) {
                        count++;
                    }   
                }
                l++;
                r--;
            }
            out[i] = count;
        }
        return out;
    }
}
