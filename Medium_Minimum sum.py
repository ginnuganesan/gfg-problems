''' PROBLEM DESCRIPTION

Given an array arr[] such that each element is in the range [0 - 9], find the minimum possible sum of two numbers formed using the elements of the array. All digits in the given array must be used to form the two numbers. Return a string without leading zeroes.

Examples :

Input: arr[] = [6, 8, 4, 5, 2, 3]
Output: 604
Explanation: The minimum sum is formed by numbers 358 and 246.
Input: arr[] = [5, 3, 0, 7, 4]
Output: 82
Explanation: The minimum sum is formed by numbers 35 and 047.
Input: arr[] = [9, 4]
Output: 13
Explanation: The minimum sum is formed by numbers 9 and 4.
Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 9

'''

#Solution

import sys
sys.set_int_max_str_digits(500000)

class Solution:
    def minSum(self, arr):
        # code here
        arr.sort()
        arr[::-1]
        num1 = 0
        num2 = 0
        for i in range(len(arr)):
            if (i % 2 == 0):
                num1 = num1 * 10 + arr[i]
            else:
                num2 = num2 * 10 + arr[i]
        return num1 + num2
