/* PROBLEM DESCRIPTION

Given two sorted arrays of distinct elements. There is only 1 difference between the arrays. First array has one element extra added in between. Find the index of the extra element.

Example 1:

Input:
N = 7
A[] = {2,4,6,8,9,10,12}
B[] = {2,4,6,8,10,12}
Output: 4
Explanation: In the second array, 9 is
missing and it's index in the first array
is 4.
Example 2:

Input:
N = 6
A[] = {3,5,7,9,11,13}
B[] = {3,5,7,11,13}
Output: 3
Your Task:
You don't have to take any input. Just complete the provided function findExtra() that takes array A[], B[] and size of A[] and return the valid index (0 based indexing).

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
2<=N<=104
1<=Ai<=105

*/

//Solution

class Solution {
    public int findExtra(int a[], int b[], int n) {
        // add code here.
        for(int i = 0; i < n; i++) {
            if(i < n-1) {
                if(a[i] != b[i]) {
                    return i;
                }
            }
        }
        return n-1;
    }
}

//Optimised Solution

class Solution {
    public int findExtra(int n, int arr1[], int arr2[]) {
        // add code here.
        if(n == 1) {
            return 0;
        }
        int i = 0, j = n - 1;
        while(i <= j) {
            if(arr1[i] == arr2[i]) {
                i++;
            } else {
                return i;
            }
            if(arr1[j] == arr2[j-1]) {
                j--;
            } else {
                return j;
            }
        }
        return -1;
    }
}
