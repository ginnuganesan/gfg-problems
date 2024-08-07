/* PROBLEM DESCRIPTION

Given two sorted arrays arr1 and arr2 and an element k. The task is to find the element that would be at the kth position of the combined sorted array.

Examples :

Input: k = 5, arr1[] = [2, 3, 6, 7, 9], arr2[] = [1, 4, 8, 10]
Output: 6
Explanation: The final combined sorted array would be - 1, 2, 3, 4, 6, 7, 8, 9, 10. The 5th element of this array is 6.
Input: k = 7, arr1[] = [100, 112, 256, 349, 770], arr2[] = [72, 86, 113, 119, 265, 445, 892]
Output: 256
Explanation: Combined sorted array is - 72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892. 7th element of this array is 256.
Expected Time Complexity: O(log(n) + log(m))
Expected Auxiliary Space: O(log (n))

Constraints:
1 <= k<= arr1.size()+arr2.size()
1 <= arr1.size(), arr2.size() <= 106
0 <= arr1[i], arr2[i] < 108

*/

//Solution

class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        // code here
        int n = arr1.length, m = arr2.length;
        int[] res = new int[n + m];
        int left = 0, right = 0, i = 0;
        while(left < n && right < m) {
            if(arr1[left] <= arr2[right]) {
                res[i] = arr1[left++];
            } else {
                res[i] = arr2[right++];
            }
            if(i == k-1) {
                return res[i];
            }
            i++;
        }
        while(left < n) {
            res[i] = arr1[left++];
            if(i == k-1) {
                return res[i];
            }
            i++;
        }
        while(right < m) {
            res[i] = arr2[right++];
            if(i == k-1) {
                return res[i];
            }
            i++;
        }
        return -1;
    }
}
