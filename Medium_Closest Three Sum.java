/* PROBLEM DESCRIPTION

Given an array, arr of integers, and another number target, find three integers in the array such that their sum is closest to the target. Return the sum of the three integers.

Note: If there are multiple solutions, return the maximum one.

Examples :

Input: arr[] = [-7, 9, 8, 3, 1, 1], target = 2
Output: 2
Explanation: There is only one triplet present in the array where elements are -7,8,1 whose sum is 2.
Input: arr[] = [5, 2, 7, 5], target = 13
Output: 14
Explanation: There is one triplet with sum 12 and other with sum 14 in the array. Triplet elements are 5, 2, 5 and 2, 7, 5 respectively. Since abs(13-12) ==abs(13-14) maximum triplet sum will be preferred i.e 14.
Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(1)

Constraints:
3 ≤ arr.size() ≤ 103
-105 ≤ arr[i] ≤ 105
1 ≤ target ≤ 105

*/

//Solution

class Solution {
    static int threeSumClosest(int[] array, int target) {
        // code here
        Arrays.sort(array);
        
        int closestSum = Integer.MAX_VALUE, n = array.length;
        
        for(int i = 0; i < n - 2; i++) {
            int l = i+1, r = n-1;
            while(l < r) {
                int sum = array[i] + array[l] + array[r];
                if(Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                } else if (Math.abs(sum - target) == Math.abs(closestSum - target)) {
                    closestSum = Math.max(sum, closestSum);
                }
                if(sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return closestSum;
    }
}
