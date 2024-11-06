'''PROBLEM DESCRIPTION

Given an unsorted array arr and a number k which is smaller than the size of the array. Return true if the array contains any duplicate within k distance throughout the array else false.

Examples:

Input: arr[] = [1, 2, 3, 4, 1, 2, 3, 4] and k = 3
Output: false
Explanation: All duplicates are more than k distance away.
Input: arr[] = [1, 2, 3, 1, 4, 5] and k = 3
Output: true
Explanation: 1 is repeated at distance 3.
Input: arr[] = [6, 8, 4, 1, 8, 5, 7] and k = 3
Output: true
Explanation: 8 is repeated at distance 3.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ k < arr.size()
1 ≤ arr[i] ≤ 105

'''

#Solution

class Solution:
    def checkDuplicatesWithinK(self, arr, k):
        # your code
        n = len(arr)
        for i in range (n-k):
            map = {}
            for j in range(i, i+k+1):
                if arr[j] in map:
                    map[arr[j]] += 1
                else:
                    map[arr[j]] = 1;
            count = 0
            for key in map.keys():
                if map[key] > 1:
                    return True
        return False