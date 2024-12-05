''' PROBLEM DESCRIPTION

Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.

Examples:

Input: arr[] = [0, 1, 2, 0, 1, 2]
Output: [0, 0, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.
Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.
Constraints:
1 <= arr.size() <= 106
0 <= arr[i] <= 2

'''

#https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1

#Solution - Dutch National Flag Algorithm

class Solution:
    # Function to sort an array of 0s, 1s, and 2s
    def sort012(self, arr):
        # code here
        n = len(arr)
        l, m, h = 0, 0, n-1
        
        while m <= h:
            if arr[m] == 0:
                arr[m], arr[l] = arr[l], arr[m]
                l = l + 1
                m = m + 1
            elif arr[m] == 1:
                m = m + 1
            else:
                arr[m], arr[h] = arr[h], arr[m]
                h = h - 1
        
        return arr
