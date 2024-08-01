/* PROBLEM DESCRIPTION

You are given a rectangular matrix, and your task is to return an array while traversing the matrix in spiral form.

Examples:

Input: matrix[][] = [[1, 2, 3, 4],
                  [5, 6, 7, 8],
                  [9, 10, 11, 12],
                  [13, 14, 15,16]]
Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
Explanation:

Input: matrix[][] = [[1, 2, 3, 4],
                  [5, 6, 7, 8],
                  [9, 10, 11, 12]]
Output: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
Explanation: Applying same technique as shown above, output for the 2nd testcase will be 1 2 3 4 8 12 11 10 9 5 6 7.
Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n2)

Constraints:
1 <= matrix.size(), matrix[0].size() <= 100
0 <= matrix[i][j]<= 100

*/

//Solution

class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        // code here
        int n = matrix.length, m = matrix[0].length;
        ArrayList<Integer> out = new ArrayList<>();
        int left = 0, top = 0, bottom = n-1, right=m-1;
        while (top <= bottom && left <= right) {
            for(int i = left; i <= right; i++) {
                out.add(matrix[top][i]);
            }
            top++;
            if(top <= bottom) {
                for(int i = top; i <= bottom; i++) {
                out.add(matrix[i][right]);
                }
                right--;
                if(right >= left) {
                    for(int i = right; i >= left; i--) {
                    out.add(matrix[bottom][i]);
                    }
                    bottom--;
                    if(bottom >= top) {
                        for(int i = bottom; i >= top; i--) {
                            out.add(matrix[i][left]);
                        }
                        left++;    
                    }
                }
            }
        }
        return out;
    }
}
