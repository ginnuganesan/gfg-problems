''' PROBLEM DESCRIPTION

Given an array, arr[] construct a product array, res[] where each element in res[i] is the product of all elements in arr[] except arr[i]. Return this resultant array, res[].
Note: Each element is res[] lies inside the 32-bit integer range.

Examples:

Input: arr[] = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]
Explanation: For i=0, res[i] = 3 * 5 * 6 * 2 is 180.
For i = 1, res[i] = 10 * 5 * 6 * 2 is 600.
For i = 2, res[i] = 10 * 3 * 6 * 2 is 360.
For i = 3, res[i] = 10 * 3 * 5 * 2 is 300.
For i = 4, res[i] = 10 * 3 * 5 * 6 is 900.
Input: arr[] = [12, 0]
Output: [0, 12]
Explanation: For i = 0, res[i] is 0.
For i = 1, res[i] is 12.
Constraints:
2 <= arr.size() <= 105
-100 <= arr[i] <= 100

'''

#Solution

class Solution:
    def productExceptSelf(self, arr):
        #code here
        zeros, z_idx, n = 0, -1, len(arr)
        total_product = 1
        
        for i in range(n):
            if arr[i] == 0:
                zeros += 1
                z_idx = i
            else:
                total_product *= arr[i]
                
        out = [0] * n
        
        if zeros == 1:
            out[z_idx] = total_product
        elif zeros == 0:
            for i in range(n):
                out[i] = total_product // arr[i]
                
        return out
