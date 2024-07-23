/* PROBLEM DESCRIPTION

Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

Example 1:

Input:
N = 7, X = 2
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 4
Explanation: 2 occurs 4 times in the
given array.
Example 2:

Input:
N = 7, X = 4
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 0
Explanation: 4 is not present in the
given array.
Your Task:
You don't need to read input or print anything.
Your task is to complete the function count() which takes the array of integers arr, n, and x as parameters and returns an integer denoting the answer.
If x is not present in the array (arr) then return 0.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ 106
1 ≤ X ≤ 106

*/

//Solution

class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int l = 0, r = n - 1, count = 0;
        while(l <= r) {
            if(arr[l] == x) {
                while(arr[l] == x) {
                    count++;
                    l++;
                }
                return count;
            } else if (arr[r] == x) {
                while(arr[r] == x) {
                    count++;
                    r--;
                }
                return count;
            } else {
                l++;
                r--;
            }
        }
        return count;
    }
}
