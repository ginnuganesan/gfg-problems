/* PROBLEM DESCRIPTION

You are given an array arr[] of N integers. The task is to find the smallest positive number missing from the array.

Note: Positive number starts from 1.

Example 1:

Input:
N = 5
arr[] = {1,2,3,4,5}
Output: 6
Explanation: Smallest positive missing 
number is 6.
Example 2:

Input:
N = 5
arr[] = {0,-10,1,3,-20}
Output: 2
Explanation: Smallest positive missing 
number is 2.
Your Task:
The task is to complete the function missingNumber() which returns the smallest positive missing number in the array.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 106
-106 <= arr[i] <= 106

*/

//Solution

class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        // Your code here
        Arrays.sort(arr);
        if(arr[size - 1] < 1 || arr[0] > 1) {
            return 1;
        }
        int ref = 1, prev = -1;
        for(int i = 0; i < size; i++) {
            //System.out.println("curr: " + arr[i] + ", prev: " + prev);
            if(arr[i] >= 1) {
                if(arr[i] == ref && arr[i] != prev) {
                    ref++;
                } else if (arr[i] != prev) {
                    return ref;
                }
            }
            prev = arr[i];
        }
        return ref;
    }
}
