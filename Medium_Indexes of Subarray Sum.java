/* PROBLEM DESCRIPTION

Given an unsorted array arr of size n that contains only non negative integers, find a sub-array (continuous elements) that has sum equal to s. You mainly need to return the left and right indexes(1-based indexing) of that subarray.

In case of multiple subarrays, return the subarray indexes which come first on moving from left to right. If no such subarray exists return an array consisting of element -1.

Examples:

Input: arr[] = [1,2,3,7,5], n = 5, s = 12
Output: 2 4
Explanation: The sum of elements from 2nd to 4th position is 12.
Input: arr[] = [1,2,3,4,5,6,7,8,9,10], n = 10, s = 15,
Output: 1 5
Explanation: The sum of elements from 1st to 5th position is 15.
Input: arr[] = [7,2,1], n = 3, s = 2
Output: 2 2
Explanation: The sum of elements from 2nd to 2nd position is 2.
Input: arr[] = [5,3,4], n = 3, s = 2
Output: -1
Explanation: There is no subarray with sum 2
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:

0 <= arr[i] <= 109
1 <= n <= 105
0 <= s <= 109

*/

//Solution

class Solution {
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // code here
        int start = 0, last = 0, currSum = 0;
        boolean flag = false;
        ArrayList<Integer> out = new ArrayList<Integer>();
        
        for(int i = 0; i < n; i++) {
            currSum += arr[i];
            
            if(currSum >= s) {
                last = i;
                
                while(s < currSum && start < last) {
                    currSum -= arr[start];
                    start++;
                }
                
                if(s == currSum) {
                    out.add(start + 1);
                    out.add(last + 1);
                    flag = true;
                    break;
                }
            }
        }
        
        if(!flag) {
            out.add(-1);
        }
        
        return out;
    }
}
