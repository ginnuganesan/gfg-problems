/* PROBLEM DESCRIPTION

Given a boolean 2D array, consisting of only 1's and 0's, where each row is sorted. Return the 0-based index of the first row that has the most number of 1s. If no such row exists, return -1.

Examples:

Input: arr[][] = [[0, 1, 1, 1],
               [0, 0, 1, 1],
               [1, 1, 1, 1],
               [0, 0, 0, 0]]
Output: 2
Explanation: Row 2 contains 4 1's (0-based indexing).
Input: arr[][] = [[0, 0], 
               [1, 1]]
Output: 1
Explanation: Row 1 contains 2 1's (0-based indexing).
Expected Time Complexity: O(n+m)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ number of rows, number of columns ≤ 103
0 ≤ arr[i][j] ≤ 1 

*/

//Solution

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int rows = arr.length, columns = arr[0].length;
        int r = 0, c = columns-1, maxRow = -1;
        while(r < rows && c >= 0) {
            if(arr[r][c] == 0) {
                r++;
            } else {
                maxRow = r;
                c--;
            }
        }
        return maxRow;
    }
}
