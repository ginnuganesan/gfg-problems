''' PROBLEM DESCRIPTION

A sorted array of distinct elements arr[] is rotated at some unknown point, the task is to find the minimum element in it. 

Examples:

Input: arr[] = [5, 6, 1, 2, 3, 4]
Output: 1
Explanation: 1 is the minimum element in the array.
Input: arr[] = [3, 1, 2]
Output: 1
Explanation: Here 1 is the minimum element.
Input: arr[] = [4, 2, 3]
Output: 2
Explanation: Here 2 is the minimum element.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 109

'''
#Solution

class Solution:
    def findMin(self, arr):
        #complete the function here
        n = len(arr)
        for i in range(1, n):
            if arr[i] < arr[i-1]:
                return arr[i]
        return arr[0]
