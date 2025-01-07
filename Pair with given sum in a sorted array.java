/* PROBLEM DESCRIPTION

You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.
Note: pairs should have elements of distinct indexes. 

Examples :

Input: arr[] = [-1, 1, 5, 5, 7], target = 6
Output: 3
Explanation: There are 3 pairs which sum up to 6 : {1, 5}, {1, 5} and {-1, 7}.
Input: arr[] = [1, 1, 1, 1], target = 2
Output: 6
Explanation: There are 6 pairs which sum up to 2 : {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1} and {1, 1}.
Input: arr[] = [-1, 10, 10, 12, 15], target = 125
Output: 0
Explanation: There is no such pair which sums up to 4.
Constraints:
-105 <= target <=105
 2 <= arr.size() <= 105
-105 <= arr[i] <= 105

*/

//Solution

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        int count = 0;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                int cnt1 = 0, cnt2 = 0;
                int ele1 = arr[left], ele2 = arr[right];
                while (left <= right && arr[left] == ele1) {
                    left++;
                    cnt1++;
                }
                while (left <= right && arr[right] == ele2) {
                    right--;
                    cnt2++;
                }
                if (ele1 == ele2) 
                    count += (cnt1 * (cnt1 - 1)) / 2;
                else 
                    count += (cnt1 * cnt2);
            } else if (sum < target)
                left++;
            else
                right--; 
        }
        return count;
    }
}
